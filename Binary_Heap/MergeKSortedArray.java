package Binary_Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    static int N=0;
    public static void main(String[] args) {
        int[][] arr=new int[][]{{10,20,30},
                                {5,15},
                                {1,9,11,18}};
        int k=3;
        int n=4;
        N=n;
        // System.out.println(getArraySorted(arr, k, n));

        // int[] output=new int[n*k];
        // mergeKArrays(arr, 0, 2, output);
        // for(Integer i:output)
        //     System.out.print(i+" ");
        List<List<Integer>> ipArr=Arrays.asList(
           Arrays.asList(10,20,30),
           Arrays.asList(5,15),
           Arrays.asList(1,9,11,18)
        );

        System.out.println(mergeKArrays(ipArr));

    }

    //TC : O(nklognk)
    // static ArrayList<Integer> getArraySorted(int[][] arr,int k,int n){
    //     ArrayList<Integer> res=new ArrayList<>();
    //     for(int i=0;i<k;i++){
    //         for(Integer e:arr[i])
    //             res.add(e);
    //     }
    //     Collections.sort(res);
    //     return res;
    // }

    //TC - Method 2 : O(nk^2)
    // static void mergeArrays(int[] arr1,int[] arr2,int n1,int n2,int[] arr3){
    //     int i=0,j=0,k=0;
    //     while(i<n1 && j<n2){
    //         if(arr1[i]<arr2[j]){
    //             arr3[k++]=arr1[i];
    //             i++;
    //         }else if(arr2[j]<arr1[i]){
    //             arr3[k++]=arr2[j];
    //             j++;
    //         }
    //     }

    //     while(i<n1)
    //         arr3[k++]=arr1[i++];

    //     while(j<n2)
    //         arr3[k++]=arr2[j++];
    // }

    // static void mergeKArrays(int[][] arr,int i,int j,int[] output){
    //     if(i==j){
    //         for(int k=0;k<N;k++){
    //             output[k]=arr[i][k];
    //             return;
    //         }
    //     }

    //     if(j-i==1){
    //         mergeArrays(arr[i], arr[j], N, N, output);
    //         return;
    //     }

    //     int[] out1=new int[(N*((i+j)/2-i+1))];
    //     int[] out2=new int[(N*(j-((i+j)/2)))];

    //     mergeKArrays(arr, i, (i+j)/2, out1);
    //     mergeKArrays(arr, (i+j)/2+1, j, out2);
    //     mergeArrays(out1, out2, N*((i+j)/2-i+1), N*(j-(i+j)/2), output);
    // }

    static List<Integer> mergeKArrays(List<List<Integer>> arr){
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Triplet> pq=new PriorityQueue<>();
        for(int i=0;i<arr.size();i++)
            pq.add(new Triplet(arr.get(i).get(0), i, 0));

        while(!pq.isEmpty()){
            Triplet curr=pq.poll();
            res.add(curr.val);
            int apos=curr.aPos,vPos=curr.vPos;
            
            if(vPos+1<arr.get(apos).size()) 
                pq.add(new Triplet(arr.get(apos).get(vPos+1), apos, vPos+1));
        }
        return res;
    }

    
}

class Triplet implements Comparable<Triplet>{
    int val,aPos,vPos;

    Triplet(int v,int ap,int vp){
        val=v;
        aPos=ap;
        vPos=vp;
    }

    public int compareTo(Triplet t){
        return val-t.val;
    }
}
