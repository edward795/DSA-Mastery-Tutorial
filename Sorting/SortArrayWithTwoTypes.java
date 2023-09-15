import utils.Print;

public class SortArrayWithTwoTypes {
    public static void main(String[] args) {
        int[] arr=new int[]{-12,18,-10,15};
        System.out.println("Array after partitioning:");

        hoaresPartition(arr);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    }

    //Naive soln - O(n) - O(n)
    static void naivePartition(int[] arr){
        int n=arr.length;
        int[] temp=new int[n];

        int k=0;
        for(int i=0;i<n;i++){
            if(arr[i]<0)
                temp[k++]=arr[i];
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0)
                temp[k++]=arr[i];
        }

        for(int i=0;i<n;i++)
            arr[i]=temp[i];
    }
    
    //TC : O(n)
    static void hoaresPartition(int[] arr){
        int n=arr.length;
        int i=-1,j=n;

        while(true){
            do{
                i++;
            }while(arr[i]<0);

            do{
                j--;
            }while(arr[j]>=0);

            if(i>=j) return;

            swap(arr,i,j);
        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
