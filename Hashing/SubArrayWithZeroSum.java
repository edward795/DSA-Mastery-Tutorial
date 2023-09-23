package Hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,13,-3,-10,5};
        System.out.println("Is a subarray with 0 present?"+isSumzero(arr));
    }

    //Naive Soln : O(n^2)
    // static boolean isSumzero(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int curr_sum=0;
    //         for(int j=i;j<n;j++){
    //             curr_sum+=arr[j];
    //             if(curr_sum==0) return true;
    //         }
    //     }
    //     return false;
    // }
    
    //Efficienln : O(n)
    static boolean isSumZero(int[] arr){
        int n=arr.length;
        HashSet<Integer> h=new HashSet<>();
        int pre_sum=0;
        for(int i=0;i<n;i++){
           pre_sum+=arr[i];

           if(h.contains(arr[i])) return true;

           if(pre_sum==0) return true;
        }
        
        return false;
    }
}
