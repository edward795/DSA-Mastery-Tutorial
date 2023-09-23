package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubArrayWithEqualNoofZeroes {
    public static void main(String[] args) {
        int[] arr=new int[]{1,0,1,1,1,0,0};
        System.out.println("Array with max subarray of equal no: of 0's & 1's : "+longestBooleanSubArr(arr));
    }

    //Naive soln : O(n^2)
    // static int longestBooleanSubArr(int[] arr){
    //     int n=arr.length;
    //     int co=0,c1=0,res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(arr[j]==0)
    //                 co++;
    //             else if(arr[j]==1) 
    //                 c1++;
    //             if(co==c1)
    //                 res=Math.max(res,j-i+1);
    //         }
    //     }
    //     return res;
    // }

    //Efficient Soln : O(n)
    static int longestBooleanSubArr(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0) arr[i]=-1;
        }
        HashMap<Integer,Integer> h=new HashMap<>();
        int pre_sum=0,res=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr[i];
            if(pre_sum==0) 
                res=i+1;
            if(h.containsKey(pre_sum)) 
                res=Math.max(res,i-h.get(pre_sum));
            else 
                h.put(pre_sum,i);
        }
        return res;
    }
}
