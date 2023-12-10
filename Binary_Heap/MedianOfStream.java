package Binary_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {
    public static void main(String[] args) {
        int[] arr=new int[]{25,7,10,15,20};
        printMedian(arr);
    }

    //Naive Soln : O(n^2)
    // static void printMedian(int[] arr){
    //     int[] temp=new int[arr.length];
    //     int k=0;
    //     for(int i=0;i<arr.length;i++){
    //         temp[k++]=arr[i];
    //         System.out.println(getMedian(temp,k));
    //     }
    // }

    //  static int getMedian(int[] temp, int k) {
    //     if(k%2!=0) 
    //         return temp[k/2];
    //     else 
    //         return (temp[k/2]+temp[(k-1)/2])/2;
    // }

    //Better Soln using augmented BST - O(nlogn) - refer kth smallest ele in BST Track
    
    //Efficient soln : O(nlogn) using 2 heaps
    static void printMedian(int[] arr){
        PriorityQueue<Integer> s=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> g=new PriorityQueue<>();

        s.add(arr[0]);
        System.out.print(arr[0]+" ");
        for(int i=1;i<arr.length;i++){
            int x=arr[i];
            if(s.size()>g.size()){
                if(s.peek()>x){
                    g.add(s.poll());
                    s.add(x);
                }else{
                    g.add(x);
                }
                System.out.print((double)(s.peek()+g.peek())/2+" ");
            }else{
                if(x<=s.peek()){
                    s.add(x);
                }else{
                    s.add(g.poll());
                    g.add(x);
                }
                System.out.print(s.peek()+" ");
            }
        }
    }
}
