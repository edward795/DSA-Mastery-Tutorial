package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfArrayElements {
    public static void main(String[] args) {
        int[] arr=new int[]{10,12,10,15,10,20,12,12};
        System.out.println("Elements and Their Frequency are:");
        printFreq(arr, arr.length);
    }
    //Naive Soln :O(n^2)
    // static void printFreq(int[] arr,int n){
    //     for(int i=0;i<n;i++){
    //         boolean flag=false;
    //         for(int j=0;j<i;j++){
    //             if(arr[i]==arr[j]){
    //                 flag=true;
    //                 break;
    //             }
    //         }

    //         if(flag==true) continue;

    //         int freq=1;
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]==arr[j])
    //                 freq++;
    //         }
    //         System.out.println(arr[i]+":"+freq);
    //     }
    // }
    
    //Efficient Soln : O(n)
    static void printFreq(int[] arr,int n){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
           hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> i:hm.entrySet()){
            System.out.println(i.getKey()+":"+i.getValue());
        }
    }
}
