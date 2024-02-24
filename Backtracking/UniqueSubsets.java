package Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class UniqueSubsets {
    public static void main(String[] args) {
        int[] arr=new int[]{2,1,2};
        int n=2;
        System.out.println("The result of unique subsets is "+allSubSets(arr,2 ));
    }

    //TC : O(2^n) - O(2^n*x)
    // static void subsetsRec(int[] arr,int index,ArrayList<Integer> subset,ArrayList<ArrayList<Integer>> res){
    //     res.add(new ArrayList<>(subset));
    //     for(int i=0;i<arr.length;i++){
    //         if(i>index && arr[i]==arr[i-1]){
    //             continue;
    //         }
    //     }

    //     subset.add(arr[index]);
    //     subsetsRec(arr,index+1,subset,res);
    //     subset.remove(subset.size()-1);
    // }

    // static ArrayList<ArrayList<Integer>> allSubSets(int[] arr,int n){
    //     Arrays.sort(arr);
    //     ArrayList<Integer> subset=new ArrayList<>();
    //     ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    //     subsetsRec(arr, 0, subset, res);
    //     return res;
    // }

    //TC : O(2^n) - O(2^n*x)
    public static ArrayList<ArrayList<Integer>> allSubsets(int arr[],int n){
        ArrayList<Integer> subset=new ArrayList<>();
        LinkedHashSet<ArrayList<Integer>> res=new LinkedHashSet<>();
        res.add(subset);
        subsets(res,subset,arr,0);
        return new ArrayList<>(res);
    }

    static void subsets(LinkedHashSet<ArrayList<Integer>> res,ArrayList<Integer> subset,int[] arr,int index){
        if(index==arr.length){
            return;
        }

        subset.add(arr[index]);
        res.add(new ArrayList<>(subset));
        subsets(res,subset,arr,index+1);
        subset.remove(subset.size()-1);
        subsets(res,subset,arr,index+1);
    }
}
