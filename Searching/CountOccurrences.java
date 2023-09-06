package Searching;

public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,3,3,3,3,4,5,6};
        System.out.println("No of occurrences:"+CountOccurrences(arr, arr.length-1, 3));
    }


    static int CountOccurrences(int[] arr,int n,int x){
        int first=indexOfFirstOccurrence(arr, n, x);
        if(first==-1) return -1;
        return (lastOccurrence(arr, n, x)-first)+1;
    }

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
