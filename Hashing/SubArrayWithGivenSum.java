package Hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr=new int[]{5,8,6,13,3,-1};
        int sum=22;

        System.out.println("Subarray with sum exists?"+isSubArrayPresent(arr, sum));
    }
    
    //Naive Soln :o(n^2)
    // static boolean isSubArrayPresent(int[] arr,int sum){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int curr_sum=0;
    //         for(int j=i;j<n;j++){
    //             curr_sum+=arr[j];

    //             if(curr_sum==sum) return true;
    //         }
    //     }
    //     return false;
    // }
    
    //Efficient Soln : O(n)
    static boolean isSubArrayPresent(int[] arr,int sum){
        int n=arr.length;
        HashSet<Integer> h=new HashSet<>();
        int pre_sum=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr[i];

            if(pre_sum==sum) return true;
            if(h.contains(pre_sum)) return true;

            h.add(pre_sum);
        }

        return false;
    }
}
