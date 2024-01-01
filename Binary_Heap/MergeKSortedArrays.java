package Binary_Heap;

import java.util.Arrays;

public class  MergeKSortedArrays{
    public static void main(String[] args) {
        int[][] arr=new int[][]{{10,20,30},
                                {5,15},
                                {1,9,11,18}};
        int k=3;
        int n=4;

        // for(Integer i:getMerged(arr, n, k))
        //     System.out.print(i+" ");
    }

    //TC : O(nklognk)
    // static int[] getMerged(int[][] arr,int n,int k){
    //     int[] res=new int[n*k];
    //     int m=0;
    //     for(int i=0;i<k;i++){
    //         for(Integer j:arr[i])
    //             res[m++]=j;
    //     }

    //     Arrays.sort(res);
    //     return res;
    // }

    static void mergeArrays(int[] arr1,int[] arr2,int n1,int n2,int[] arr3){
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            
        }
    }
}