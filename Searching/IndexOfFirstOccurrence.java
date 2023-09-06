package Searching;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,3,4,5};
        System.out.println("1st Occurrence found at index:"+indexOfFirstOccurrence(arr, arr.length-1, 3));
    }

    //Efficent Soln : O(logn) - O(1)
    static int indexOfFirstOccurrence(int[] arr,int n,int x){
        int low=0,high=n-1;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]>x)
                high=mid-1;
            else if(arr[mid]<x)
                low=mid+1;
            else{
                if(mid==0 || arr[mid-1]!=arr[mid])
                    return mid;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}
