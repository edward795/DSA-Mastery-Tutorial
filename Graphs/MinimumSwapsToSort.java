package Graphs;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsToSort {

    static int cycle_size=0;
    public static void main(String[] args) {
        int[] nums=new int[]{2,8,5,4};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int nums[]){
        HashMap<Integer,Integer> hm=new HashMap<>();
        boolean[] visited=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }

        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(visited[i] || hm.get(nums[i])==i){
                continue;
            }

            if(!visited[i]){
                int j=i;
                while(!visited[j]){
                    visited[j]=true;
                    j=hm.get(nums[j]);
                    cycle_size++;
                }
            }
        }

        if(cycle_size>0){
            ans+=(cycle_size-1);
        }

        return ans;
    }
}
