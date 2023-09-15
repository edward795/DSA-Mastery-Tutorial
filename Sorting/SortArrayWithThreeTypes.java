import utils.Print;

public class SortArrayWithThreeTypes {
    public static void main(String[] args) {
        int[] arr=new int[]{0,1,0,2,1,2};
        System.out.println("Array after parrtitioning:");

        sort4types(arr);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    }
    
    //Naive Partitioning : O(4n)~O(n) - O(n)
    static void naivePartition(int[] arr){
        int n=arr.length;
        int[] temp=new int[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)
                temp[k++]=arr[i];
        }

        for(int i=0;i<n;i++){
            if(arr[i]==1)
                temp[k++]=arr[i];
        }

        for(int i=0;i<n;i++){
            if(arr[i]==2)
                temp[k++]=arr[i];
        }

        for(int i=0;i<n;i++)
            arr[i]=temp[i];
    }
    
    //Efficient Soln : Dutch National Flag Algorithm : O(n) - O(1)
    static void sort4types(int[] arr){
        int n=arr.length;
        int low=0,mid=0,high=n-1;

        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }
    }


    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
