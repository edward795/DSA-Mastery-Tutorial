package Hashing;

import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr=new int[]{10,20,20,10,30,40,10};
        int k=4;
        System.out.println("The count of distinct elements in every window is : ");
        printDistinct(arr, k);
    }

    //Naive Soln : O(n^2)
    // static void printDistinct(int[] arr,int k){
    //     int n=arr.length;
    //     for(int i=0;i<=n-k;i++){
    //         int count=0;
    //         for(int j=0;j<k;i++){
    //             boolean flag=false;
    //             for(int p=0;p<j;p++){
    //                 if(arr[i+j]==arr[i+p]){
    //                     flag=true;
    //                     break;
    //                 }
    //             }
    //             if(flag==false) 
    //                 count++;
    //         }
    //         System.out.println(count);
    //     }
    // }
    
    //Efficient Soln : O(n) - O(n)
    static void printDistinct(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i=0;i<k;i++)
            h.put(arr[i],h.getOrDefault(arr[i], 0)+1);
        System.out.println(h.size());

        for(int i=k;i<n;i++){
            if(h.get(arr[i-k])==1){
                h.remove(arr[i-k]);
            }else{
                h.put(arr[i-k],h.getOrDefault(arr[i-k],0)-1);
            }

            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
            System.out.println(h.size());
        }
    }
}
