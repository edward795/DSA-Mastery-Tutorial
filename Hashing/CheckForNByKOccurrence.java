package Hashing;
import java.util.Arrays;
import java.util.HashMap;

public class CheckForNByKOccurrence {
    public static void main(String[] args) {
        int[] arr=new int[]{30,10,20,20,10,20,30,30};
        int k=4;
        System.out.println("Elements with count values greater than n/k are : ");
        printNByK(arr, k);
    }

    //Naive Soln : O(n^2)
    // static void printNByK(int[] arr,int k){
    //     int n=arr.length;
    //     Arrays.sort(arr);
    //     int i=1,count=1;

    //     while(i<n){
    //         while(i<n && arr[i]==arr[i-1]){
    //             count++;
    //             i++;
    //         }

    //         if(count>n/k) 
    //             System.out.println(arr[i-1]+" ");
    //         i++;
    //         count=1;
    //     }
    // }

    //Efficient Soln : O(nk)
    static void printNByK(int[] arr,int k){
        int n=arr.length;
        HashMap<Integer,Integer> h=new HashMap<>();

        for(int i=0;i<n;i++){
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }

        for(Integer i:h.keySet()){
            if(h.get(i)>n/k)
                System.out.print(i+" ");
        }
    }
}
