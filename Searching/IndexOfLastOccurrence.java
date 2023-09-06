package Searching;

public class IndexOfLastOccurrence {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,3,3,4,5};
        int x=3;
        System.out.println("The index of last occuurence is:"+lastOccurrence(arr, arr.length-1, x));
    }
    
    //TC : O(logn)
    static int lastOccurrence(int[] arr,int n,int x){
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>x)
                high=mid-1;
            else if(arr[mid]<x) 
                low=mid+1;
            else{
                if(mid==n-1 || arr[mid]!=arr[mid+1])
                    return mid;
                else 
                    low=mid+1;
            } 
        }
        return -1;
    }
}
