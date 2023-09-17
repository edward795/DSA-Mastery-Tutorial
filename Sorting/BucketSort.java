import java.util.ArrayList;
import java.util.Collections;

import utils.Print;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr=new int[]{20,88,70,85,75,95,18,82,60,34};
        System.out.println("After sorting the array is:");

        bucketSort(arr);
        Print pr=new Print();
        pr.printArray(arr, arr.length);
    }
    
    //TC :O(n+k)
    static void bucketSort(int[] arr){
        int n=arr.length;
        int max_val=arr[0];
        for(int i=0;i<n;i++)
            max_val=Math.max(max_val,arr[i]);

        max_val++;

        ArrayList<ArrayList<Integer>> bkt=new ArrayList<ArrayList<Integer>>();
        int k=n; //no: of buckets =~ no: of elements
        for(int i=0;i<k;i++){
            bkt.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            int bi=(k*arr[i])/max_val;
            bkt.get(bi).add(arr[i]);
        }

        for(int i=0;i<k;i++)
            Collections.sort(bkt.get(i));
        

        int index=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<bkt.get(i).size();j++)
                arr[index++]=bkt.get(i).get(j);
        }
    }
}
