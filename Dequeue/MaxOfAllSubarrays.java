package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxOfAllSubarrays {
    public static void main(String[] args) {
        int[] arr=new int[]{10,8,5,12,15,7,6};
        printMaxSubarrays(arr, 3);
    }

    //Naive Soln : O(n^2) - O(1)
    // static void printMaxSubarrays(int[] arr,int k){
    //     int n=arr.length;
    //     for(int i=0;i<n-k+1;i++){
    //         int mx=arr[i];
    //         for(int j=i;j<i+k;j++){
    //             mx=Math.max(arr[j],mx);
    //         }
    //         System.out.print(mx+" ");
    //     }
    // }
    
    //Efficient Soln : O(n) - O(n)
    static void printMaxSubarrays(int[] arr,int k){
        int n=arr.length;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[i]>arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        System.out.print(arr[dq.peek()]+" ");

        for(int i=k;i<n;i++){
            while(!dq.isEmpty() && arr[i-k]>=arr[dq.peekFirst()])
                dq.removeFirst();
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
            System.out.print(arr[dq.peek()]+" ");
        }
    }
}
