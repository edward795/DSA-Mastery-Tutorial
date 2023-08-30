package Arrays.PrefixSum;

import java.util.HashMap;
import java.util.Map;

public class RangeQuerySum {

    static int[] prefix_sum;
    public static void main(String[] args) {
        int[] arr=new int[]{2,8,3,7,6,5,4};
        
        //Range queries stored in hashmap
        HashMap<Integer,Integer> queries=new HashMap<>();
        queries.put(0,2);
        queries.put(1,3);
        queries.put(2,6);

        for(Map.Entry<Integer,Integer> q:queries.entrySet()){
            int l=q.getKey();
            int r=q.getValue();
            System.out.println("prefix sum from range: "+l+" to "+r+" : "+getSum(arr, l, r));
        }
        
    }

    //TC: O(n)
    static int getSum(int[] arr,int l,int r){
        int n=arr.length;
        prefix_sum=new int[n];
        prefix_sum[0]=arr[0];

        for(int i=1;i<n;i++)
            prefix_sum[i]=prefix_sum[i-1]+arr[i];

        if(l==0)
            return prefix_sum[r];
        else 
            return prefix_sum[r]-prefix_sum[l];
    }
}
