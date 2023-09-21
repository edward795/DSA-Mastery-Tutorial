package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElementsInAnArray {
    public static void main(String[] args) {
        int[] arr=new int[]{15,12,13,12,13,13,18};
        System.out.println("Print distinct elements:"+printDistinctElements(arr));
    }
    
    //Naive Solution : O(n^2)
    // static int printDistinctElements(int[] arr){
    //     int res=0,n=arr.length;
    //     for(int i=0;i<n;i++){
    //         boolean flag=false;
    //         for(int j=0;j<i;j++){
    //             if(arr[i]==arr[j]){
    //                 flag=true;
    //                 break;
    //             }
    //         }
    //         if(!flag) res++;
    //     }
    //     return res;
    // }
    
    //Efficient Soln : O(n)
    static int printDistinctElements(int[] arr){
        HashSet<Integer> h=new HashSet<>();
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(h.add(arr[i])) count++;
        }
        return count;
    }

    //Efficient -Oneliner
    // static int printDistinctElements(Integer[] arr){
    //     HashSet<Integer> h=new HashSet<>(); 
    //     return h.size();
    // }
}
