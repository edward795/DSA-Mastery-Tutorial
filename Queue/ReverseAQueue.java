package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseAQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        printQueue(q);

        reverseQueue(q);

        printQueue(q);
    }

    //TC : iterative  : O(n) - O(n)
    // static void reverseQueue(Queue<Integer> q){
    //     Stack<Integer> st=new Stack<>();
    //     while(!q.isEmpty()){
    //         st.push(q.poll());
    //     }

    //     while(!st.isEmpty()){
    //         q.offer(st.pop());
    //     }
    // }

    //TC : O(n) - O(n)
    static void reverseQueue(Queue<Integer> q){
        if(q.isEmpty()) return;
        int x=q.peek();
        q.poll();
        reverseQueue(q);
        q.offer(x);
    }

    static void printQueue(Queue<Integer> q){
        for(Integer i:q)
            System.out.print(i+" ");
        System.out.println();
    }
}
