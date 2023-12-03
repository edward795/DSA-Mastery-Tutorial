package Binary_Heap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{10,15,50,4,20};
        MaxHeap hp=new MaxHeap(5);
        //TC : O(nlogn)
        hp.heapsort(arr, 5);
        for(Integer i:arr)
            System.out.print(i+" ");
    }
}

class MaxHeap{
    int[] arr;
    int size,capacity;

    MaxHeap(int c){
        capacity=c;
        arr=new int[c];
        size=0;
    }   

    int left(int i){ return 2*i+1; }
    int right(int i){ return 2*i+2; }
    int parent(int i){ return (i-1)/2; }

    //TC : O(logn)
    void insert(int x){
        if(size==capacity) return;
        arr[size++]=capacity;

        for(int i=size-1;i!=0 && arr[parent(i)]<arr[i];){
            swap(arr,i,parent(i));
            i=parent(i);
        }
    }

    //TC : O(logn)
    void maxHeapify(int[] arr,int i){
        int largest=i,left=left(i),right=right(i);
        if(left<size && arr[left]>arr[largest]){
            largest=left;
        }

        if(right<size && arr[right]>arr[largest]){
            largest=right;
        }

        if(largest!=i){
            swap(arr,i,largest);
            maxHeapify(arr, largest);
        }
    }

    //TC : O(n)
    void buildHeap(int arr[],int n){
        for(int i=(size-2)/2;i>=0;i--){
            maxHeapify(arr, i);
        }
    }
    
    //TC : O(n)
    void heapsort(int arr[],int n){
        buildHeap(arr, n);
        for(int i=n-1;i>=1;i--){
            swap(arr,0,i);
            maxHeapify(arr, 0);
        }
    }

    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
