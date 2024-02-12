package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CombinationSum{
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(7,2,6,5));
        int sum=16;
        System.out.println("The cobinations are : "+combinationSum(arr, sum));
    }

    static void comboSum(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> arr,int sum,int index,ArrayList<Integer> temp){
        if(sum==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<arr.size();i++){
            if(sum-arr.get(i)>=0){
                temp.add(arr.get(i));
                comboSum(ans,arr,sum-arr.get(i),index,temp);
                temp.remove(arr.get(i));
            }
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr,int sum){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        Set<Integer> set=new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        comboSum(ans,arr,sum,0,temp);
        return ans;
    }
}