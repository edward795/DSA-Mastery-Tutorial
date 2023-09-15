import java.util.Arrays;

public class KthSmallestElementInAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{10,5,30,12};
        int n=arr.length; 
        int k=2;
        System.out.println("KthSmallest Element is:"+arr[quickSelect(arr,0,n-1,k)]);
    }
    
    //Naive Soln : O(nlogn)
    // static int kthSmallest(int[] arr,int n,int k){
    //     Arrays.sort(arr);
    //     return arr[k-1];
    // }
    
    //Efficient Soln : a.k.a Auick Select Algorithm - O(logn)
    static int quickSelect(int[] arr,int l,int h,int k){
        while(l<=h){
            int p=lomutoPartition(arr, l, h);
            if(p==k-1)
                return p;
            else if(p>k-1)
                h=p-1;
            else 
                l=p+1;
        }
        return -1;
    }

    static int lomutoPartition(int[] arr,int l,int h){
        int pivot=arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }


    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
