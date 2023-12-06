package Binary_Heap;

import java.util.PriorityQueue;

public class SortKSortedArrays {
    public static void main(String[] args) {
        int[] arr=new int[]{9,8,7,18,19,19,17};
        for(Integer i:arr) 
            System.out.print(i+" ");
    }

    //TC : O(n+k)(logk)
    // static void sortK(int[] arr,int k){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     for(int i=0;i<k;i++){
    //         pq.add(arr[i]);
    //     }

    //     for(int i=0;i<arr.length;i++){
    //         arr[i-k]=pq.poll();
    //         pq.add(arr[i]);
    //     }
    // }

    static void sortK(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++)
            pq.add(arr[i]);

        int index=0;
        for(int i=k+1;i<arr.length;i++){
            arr[index++]=pq.poll();
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()) 
            arr[index++]=pq.poll();
    }
}
