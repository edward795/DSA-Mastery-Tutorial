public class BubbleSort {
    public static void main(String[] args) {
        int[] arr=new int[]{2,23,12,5,6,7,22,50,45};
        int n=arr.length;

        printArray(arr, n);

        //after sorting
        bestBubbleSort(arr, n);
        printArray(arr, n);
    }
    
    //TC : O(n^2)
    static void bubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    } 

    //TC : O(n^2)
    static void optimisedBubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }
        }
    }


    //TC : O(n^2) (O(n) if array is already sorted)
    static void bestBubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=true;
                }
            }
            if(flag==false) break;
        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }


    static void printArray(int[] arr,int n){
        for(int i=0;i<n-1;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
