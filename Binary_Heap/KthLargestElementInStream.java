package Binary_Heap;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int[] arr=new arr[]{1,2,3,4,5,6};
        int n=6,k=3;
        kthLargest(arr,n,k);
    }


    //TC : O(nlogk) - O(k)
    // static void kthLargest(int[] arr,int n,int k){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     for(int i=0;i<n;i++){
    //         if(pq.size()<k){
    //             pq.offer(arr[i]);
    //         }else{
    //             if(arr[i]>pq.peek()){
    //                 pq.poll();
    //                 pq.offer(arr[i]);
    //             }
    //         }
    //         if(pq.size()<k){
    //             System.out.print(-1+" ");
    //         }else{
    //             System.out.print(arr[i]+" ");
    //         }
    //     }
    // }

    //TC : O(nlogk) - O(k)
    static void kthLargest(int[] arr,int n,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.offer(arr[i]);
            System.out.print(arr[i]+" ");
        }
        pq.offer(arr[k-1]);
        System.out.print(pq.peek()+" ");

        for(int i=k;i<n;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
            System.out.print(pq.peek()+" ");
        }
    }
}
