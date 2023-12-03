package Binary_Heap;

public class MinHeap{
    int arr[];
    int size;
    int capacity;

    MinHeap(int c){
        arr=new int[c];
        capacity=c;
        size=0;
    }

    int left(int i){ return (2*i+1); }
    int right(int i){ return (2*i+2); }
    int parent(int i){ return (i-1)/2; }

    //TC : (logn)
    void minHeapify(int i){
        int lt=left(i);
        int rt=right(i);
        int smallest=i;

        if(lt<size && arr[lt]<arr[i]) 
            smallest=lt; 

        if(rt<size && arr[rt]<arr[i])
            smallest=rt; 

        if(smallest!=i){
            swap(arr,i,smallest);
            minHeapify(smallest);
        } 
    }

    void insert(int x){
        if(size==capacity) return;
        arr[size++]=x;

        for(int i=size-1;i!=0 && arr[parent(i)]>arr[i];){
            swap(arr,i,parent(i));
            i=parent(i);
        }
    }

    //TC : O(logn)
    int extractMin(){
        if(size==0) 
            return Integer.MAX_VALUE;

        if(size==1){
            size--;
            return arr[0];
        }

        swap(arr,0,size-1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    //TC : O(logn)
    void decreaseKey(int i,int x){
        arr[i]=x;
        while(i!=0 && arr[parent(i)]>arr[i]){
            swap(arr,i,parent(i));
            i=parent(i);
        }
    }

    //TC : O(logn)
    void deleteKey(int i){
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    //TC : O(n)
    void buildHeap(){
        for(int i=(size-2)/2;i>=0;i--){
            minHeapify(i);
        }
    }

    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}