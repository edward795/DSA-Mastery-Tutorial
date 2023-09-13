import utils.Print;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr=new int[]{5,8,12,14,7};
        Print p=new Print();
        p.printArray(arr,arr.length);
        
        //After Sorting
        mergeSort(arr, 0, arr.length-1);
        p.printArray(arr,arr.length);

    }
    
    //TC : O(nlogn) - O(n)
    static void mergeSort(int[] arr,int l, int r){
        if(r>l){
            int m=(l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    //Merge function of merge sort - merge 2 subarrays within an array
    static void merge(int[] arr,int l,int m,int r){
        int n1=m-l+1,n2=r-m;
        int[] left=new int[n1];
        int[] right=new int[n2];

        for(int i=0;i<n1;i++) left[i]=arr[l+i];
        for(int i=m;i<n2;i++) right[i]=arr[m+i+1];

        int i=0,j=0,k=0;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }

    }  
}
