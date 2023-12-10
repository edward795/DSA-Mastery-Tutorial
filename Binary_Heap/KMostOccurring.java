package Binary_Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostOccurring {
    public static void main(String[] args) {
        int n=8;
        int[] arr=new int[]{3,1,4,4,5,2,6,1};
        int k=2;
        System.out.println("The value of most frequent is "+kMostFrequent(arr, n, k));
    }

    //TC : O(nlogn)
    static int kMostFrequent(int arr[],int n,int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        pq.addAll(hm.entrySet());

        int sm=0;
        for(int i=0;i<k;i++){
            sm+=pq.poll().getValue();
        }
        return sm;
    }
}
