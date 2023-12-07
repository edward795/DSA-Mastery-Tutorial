package Binary_Heap;

import java.util.PriorityQueue;

public class printKClosest {
    public static void main(String[] args) {
        int[] arr=new int[]{100,80,10,5,70};
        int x=2,k=3;
        printKthClosest(arr,4,k,x);
    }

    //TC : O(n) - O(nk)
    // static void printKthClosest(int[] arr,int n,int k,int x){
    //     boolean[] visited=new boolean[n];
    //     for(int i=0;i<k;i++){
    //         int min_diff=Integer.MAX_VALUE;
    //         int min_idx=0;
    //         for(int j=0;j<n;j++){
    //             if(visited[j]==false && Math.abs(arr[j]-x)<=min_diff){
    //                 min_diff=Math.abs(arr[j]-x);
    //                 min_idx=j;
    //                 visited[j]=true;
    //             }
    //         }
    //         System.out.print(arr[min_idx]+ " ");
    //     }
    // }

    //TC : O(nk) - O(n)
    static void printKthClosest(int[] arr,int n,int k,int x){
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
        for(int i=0;i<k;i++) 
            pq.add(new Pair(arr[i]-x, i));

        for(int i=k;i<n;i++){
            int diff=Math.abs(arr[i]-x);
            if(pq.peek().diff>diff){
                pq.poll();
                pq.add(new Pair(diff,i));
            }
        }

        while(!pq.isEmpty()){
            System.out.print(arr[pq.poll().index]+" ");
        }
    }
}


class Pair{
    int diff;
    int index;

    Pair(int d,int i){
        diff=d;
        index=i;
    }
}