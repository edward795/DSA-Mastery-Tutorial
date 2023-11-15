package Trees.Binary_Search_Tree;

import java.util.TreeSet;

public class CeillingOnLeftSide {
    public static void main(String[] args) {
        int[] arr=new int[]{2,8,30,15,25,12};
        leftCeiling(arr);
    }

    //Naive soln : O(n^2) - O(1)
    // static void leftCeiling(int[] arr){
    //     int n=arr.length;
    //     System.out.print(-1+" ");
    //     for(int i=1;i<n;i++){
    //         int diff=Integer.MAX_VALUE;
    //         for(int j=0;j<i;j++){
    //             if(arr[j]>=arr[i])
    //                 diff=Math.min(diff,arr[j]-arr[i]);
    //         }

    //         if(diff==Integer.MAX_VALUE)
    //             System.out.print(-1+" ");
    //         else 
    //             System.out.print(diff+arr[i]+" ");
    //     }
    // }

    //TC : O(nlogn) - O(1)
    static void leftCeiling(int[] arr){
        int n=arr.length;
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(arr[0]);
        for(int i=1;i<n;i++){
            if(ts.ceiling(arr[i])!=null)
                System.out.print(ts.ceiling(arr[i])+" ");
            else    
                System.out.print(-1+" ");
            ts.add(arr[i]);
        }
    }
}
