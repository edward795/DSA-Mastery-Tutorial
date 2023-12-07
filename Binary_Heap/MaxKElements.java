package Binary_Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxKElements {
    public static void main(String[] args) {
        int[] arr=new int[]{5,15,10,20,8};
        int k=3;
        getKLargest(arr, 3);
    }

    //TC : O(n+klogn)
    // static void getKLargest(int[] arr,int k){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    //     for(Integer i:arr) 
    //         pq.add(i);
    //     while(k>0){
    //         System.out.print(pq.poll()+" ");
    //         k--;
    //     }
    // }

    //TC : O(k + (n-k) * logk)
    static void getKLargest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(arr[i]);

        for(int i=k;i<arr.length;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }

        while(!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }
}
