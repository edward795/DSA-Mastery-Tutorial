import utils.Print;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr=new int[]{10,15,50,4,20};

        System.out.println("Array after sorting:");
        heapSort(arr, arr.length);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    } 

    //TC : O(nlogn) in all cases
    static void heapSort(int[] arr,int n){
        buildHeap(arr, n);
        for(int i=n-1;i>=1;i--){
            swap(arr,0,i);
            maxHeapify(arr, i,0);
        }
    }
    //TC : O(n)
    static void buildHeap(int[] arr,int n){
        for(int i=(n-2)/2;i>=0;i--)
            maxHeapify(arr,n,i);
    }
    
    //TC : O(logn)
    static void maxHeapify(int[] arr,int n,int i){
        int largest=i,left=2*i+1,right=2*i+2;

        if(left<n && arr[left]>arr[largest]) largest=left;
        if(right<n && arr[right]>arr[largest]) largest=right;

        if(largest!=i){
            swap(arr,i,largest);
            maxHeapify(arr, n, largest);
        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


}
