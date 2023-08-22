package Bitwise_Operators;

import java.util.Arrays;

public class FindTheMissingNumber {
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,3};
        System.out.println("Missing element from the given array is:"+getMissingNumber(arr));
    }
    
    //Naive Soln - O(nlogn)
    // public static int getMissingNumber(int[] arr){
    //     Arrays.sort(arr);
    //     int n=arr[arr.length-1];
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]!=i+1){
    //             return i+1;
    //         }
    //     }
    //     return -1;
    // }

    //Efficient Soln - O(n)
    public static int getMissingNumber(int[] arr){
        int res=0;
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            res=res^arr[i];
            mx=Math.max(mx,arr[i]);
        }

        for(int i=1;i<=mx;i++){
            res=res^i;
        }

        return res;
    }

}
