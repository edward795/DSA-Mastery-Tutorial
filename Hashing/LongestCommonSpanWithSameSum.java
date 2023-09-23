package Hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSum{
    public static void main(String[] args) {
        int[] arr1=new int[]{0,1,0,0,0,0};
        int[] arr2=new int[]{1,0,1,0,0,1};
        System.out.println("The length of longest common span with same sum : "+maxCommon(arr1, arr2, arr1.length));
    }

    //TC : O(n^2)
    // static int maxCommon(int[] arr1,int[] arr2,int n){
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int sum1=0,sum2=0;
    //         for(int j=i;j<n;j++){
    //             sum1+=arr1[j];
    //             sum2+=arr2[j];

    //             if(sum1==sum2){
    //                 res=Math.max(res,j-i+1);
    //             }
    //         }
    //     }
    //     return res;
    // }

    //Efficient Soln : O(n) - O(n)
    static int maxCommon(int[] arr1,int[] arr2,int n){
        //substract arr2 from arr1 & make it as 0 sum problem
        for(int i=0;i<n;i++){
            arr1[i]=arr1[i]-arr2[i];
        }

        HashMap<Integer,Integer> h=new HashMap<>();
        int pre_sum=0,res=0;
        for(int i=0;i<n;i++){
            pre_sum+=arr1[i];
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