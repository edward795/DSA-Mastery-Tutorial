package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        int[] arr=new int[]{1,9,3,4,2,20};
        System.out.println("Print longest subsequence : "+longestSubSequence(arr));
    }

    //TC : O(nlogn)
    // static int longestSubSequence(int[] arr){
    //     int n=arr.length;
    //     Arrays.sort(arr);
    //     int res=1,curr_sum=1;
    //     for(int i=1;i<n;i++){
    //         if(arr[i]==arr[i-1]+1){
    //             curr_sum++;
    //         }else{
    //             res=Math.max(res,curr_sum);
    //             curr_sum=1;
    //         }
    //     }
    //     return Math.max(res,curr_sum);
    // }
    
    //Efficient Soln : O(n) - O(n)
    static int longestSubSequence(int[] arr){
        int n=arr.length;
        HashSet<Integer> h=new HashSet<>();
        for(int i:arr) 
            h.add(i);

        int res=1; 
        for(Integer i:h){
            if(h.contains(i-1)==false){
                int curr=1;
                while(h.contains(i+curr))
                    curr++;
                res=Math.max(res,curr);
            }
        }
        return res;
    }
}
