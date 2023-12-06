package Binary_Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PurchaseMax {
    public static void main(String[] args) {
        int[] arr=new int[]{1,12,5,1,1,100};
        int sum=10;
        System.out.println(countItems(arr, sum));
    }

    //TC : O(n)+O(res*logn)
    // static int countItems(int[] arr,int sum){
    //     int count=0;
    //     Arrays.sort(arr);
    //     for(Integer i:arr){
    //         if(sum-i>=0){
    //             sum-=i;
    //             count++;
    //         }
    //     }
    //     return count;
    // }

    //TC : O(n) + O(res*logn)
    static int countItems(int[] arr,int sum){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Integer i:arr)  
            pq.add(i);
        int count=0;
        while(!pq.isEmpty()){
            if(sum-pq.poll()>=0){
                count++;
            }else if(sum-pq.poll()<0){
                break;
            }
        }
        return count;
    }
}
