package Hashing;

import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr=new int[]{3,2,8,15,-8};
        int sum=17;
        System.out.println("Pair of elements with Sum 17 exists? : "+isSumPair(arr, sum));
    }

    //Time Complexity : O(n^2)
    // static boolean isSumPair(int[] arr,int sum){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]+arr[j]==sum) return true;
    //         }
    //     }
    //     return false;
    // }

    //Efficient Soln : O(n)
    static boolean isSumPair(int[] arr,int sum){
        int n=arr.length;
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<n;i++){
            if(h.contains(sum-arr[i])) return true;
            h.add(arr[i]);
        }
        return false;
    }
}
