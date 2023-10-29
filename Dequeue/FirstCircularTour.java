package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstCircularTour {
    public static void main(String[] args) {
        int[] petrol=new int[]{4,8,7,4};
        int[] dist=new int[]{6,5,3,5};
        System.out.println(firstPetrolPump(petrol, dist, 4));
    }

    //Naive Soln : O(n^2) - O(1)
    // static int firstPetrolPump(int[] petrol,int[] dist,int n){
    //     for(int start=0;start<n;start++){
    //         int curr_petrol=0;
    //         int end=start;
    //         while(true){
    //             curr_petrol+=(petrol[end]-dist[end]);
    //             if(curr_petrol<0)
    //                 break;
    //             end=(end+1)%n;
    //             if(end==start) 
    //                 return (start+1);
    //         }
    //     }
    //     return -1;
    // }

    //Efficient Soln:O(n) - O(n)
    static int firstPetrolPump(int[] petrol,int[] dist,int n){
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int curr_petrol=petrol[i]-dist[i];
            if(curr_petrol>=0){
                dq.addLast(i);
            }else if(!dq.isEmpty()){
                dq.removeFirst();
            }
        }
        return dq.peekLast();
    }
}
