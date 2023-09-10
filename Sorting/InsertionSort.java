public class InsertionSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,23,12,5,6,7,22,50,45};
        int n=arr.length;
        printArray(arr, n);

        //After sorting
        insertionSort(arr, n);
        printArray(arr, n);

    }
    //TC : O(n^2)
    static void insertionSort(int[] arr,int n){
        for(int i=1;i<n-1;i++){
            int j=i-1;
            int key=arr[i];
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    
    static void printArray(int[] arr,int n){
        for(int i=0;i<n-1;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
