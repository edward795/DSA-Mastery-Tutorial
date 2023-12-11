package Binary_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream{

    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        int[] arr=new int[]{5,15,1,3};
        int n=4;
        findMedian(arr, n);
    }

    //TC : O(nlogn)
    static void findMedian(int[] arr,int n){
        for(int i=0;i<n;i++){
            insertHeap(arr[i]);
            System.out.print(getMedian()+" ");
        }
    }

    static void insertHeap(int x){
        if(maxHeap.size()==0||maxHeap.peek()>x){
            maxHeap.offer(x);
        }else{
            minHeap.offer(x);
        }
        balanceHeaps();
    }

    static void balanceHeaps(){
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    static double getMedian(){
        if(minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }else{
            return maxHeap.peek();
        }
    }
}