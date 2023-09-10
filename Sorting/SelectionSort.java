public class SelectionSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,23,12,5,6,7,22,50,45};
        int n=arr.length;
        printArray(arr, n);

        //After sorting the array 
        selectionSort(arr, n);
        printArray(arr, n);

    }

    static void printArray(int[] arr,int n){
        for(int i=0;i<n-1;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    //Naive impl : O(n^2) - O(n)
    // static void selectionSort(int[] arr,int n){
    //     int[] temp=new int[n];
    //     for(int i=0;i<n;i++){
    //         int min_index=0;
    //         for(int j=1;j<n;j++){
    //             if(arr[j]<arr[min_index])
    //                 min_index=j;
    //         }
    //         temp[i]=arr[min_index];
    //         arr[min_index]=Integer.MAX_VALUE;
    //     }

    //     for(int i=0;i<n;i++)
    //         arr[i]=temp[i];
    // }
  

    //Efficient Soln : O(n^2) - O(1)
    static void selectionSort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int min_index=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min_index])
                    min_index=j;
            }
            swap(arr, i, min_index);
        }
    }


    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
