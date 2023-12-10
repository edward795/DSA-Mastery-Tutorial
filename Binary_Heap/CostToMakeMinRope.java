package Binary_Heap;

import java.util.PriorityQueue;

public class CostToMakeMinRope {
    public static void main(String[] args) {
        int[] arr=new int[]{4,3,2,6};
        int n=4;

        System.out.println("The min cost to make ropes is "+minCost(arr, n));
    }

    //TC : O(nlogn)
    static long minCost(int arr[],int n){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
            pq.add(arr[i]);

        int res=0;
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            res+=(a+b);
            pq.offer(a+b);
        }
        return res;
    }
}
