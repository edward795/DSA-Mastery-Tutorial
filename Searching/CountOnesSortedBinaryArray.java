package Searching;

public class CountOnesSortedBinaryArray {
    public static void main(String[] args) {
        int[] arr=new int[]{0,0,0,1,1,1,1};
        System.out.println("The count of ones:"+countOnes(arr, arr.length));
    }
    
    //TC : O(logn)
    static int countOnes(int[] arr,int n){
        int low=0,high=n-1;
        while(low<high){
            int mid=(low+high)/2;
            if(arr[mid]==0)
                low=mid+1;
            else{
                if(mid==0 || arr[mid]!=arr[mid-1])
                    return n-mid;
                else 
                    high=mid-1;
            }
        }
        return -1;
    }
}
