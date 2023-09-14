import utils.Print;

public class ParitioningAnArray {
    /**
     * Partitions are based on a pivot element
     */
    public static void main(String[] args) {
        // int[] arr=new int[]{3,8,6,12,10,7};
        int[] arr=new int[]{5,3,8,4,2,7,1,10};
        int n=arr.length;
        int p=n-1; //pivot is taken as last element of the array
        System.out.println("After partitioning the array:");
        // partition(arr,0,n-1,p);
        // Print pr=new Print();
        // pr.printArray(arr, n);

        //lomuto partitioning algorithm
        // lomutoPartition(arr, 0,n-1);
        // Print pr=new Print();
        // pr.printArray(arr, n);

        //lomuto partitioning algorithm
        hoaresPartition(arr, 0,n);
        Print pr=new Print();
        pr.printArray(arr, n);
        
    }
    
    //NAive Soln : a.k.a Naive Partitioning Algorithm - O(n) -O(n)
    static void partition(int[] arr,int l,int h,int p){
        int temp[]=new int[h-l+1];
        int k=0;

        for(int i=l;i<=h;i++){
            if(arr[i]<=arr[p])
                temp[k++]=arr[i];
        }

        for(int i=l;i<=h;i++){
            if(arr[i]>arr[p])
                temp[k++]=arr[i];
        }

        for(int i=l;i<=h;i++)
            arr[i]=temp[i-l];
    }

   //Lomuto Partition - O(n) -O(1)
    static int lomutoPartition(int[] arr,int l,int h){
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<h;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }

    //Hoare's Partition : O(n) - O(1)
    static int hoaresPartition(int[] arr,int l, int h){
        int i=l-1,j=h-1;
        int pivot=arr[l];

        while(true){
            do{
                i++;
            }while(arr[i]<pivot);

            do{
                j--;
            }while(arr[j]>pivot);

            if(i>=j) return j;

            swap(arr,i,j);

        }
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

}
