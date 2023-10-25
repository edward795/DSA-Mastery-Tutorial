package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKEleInQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        printQueue(q);
        reverseFirstKElements(q, 3);
        printQueue(q);

    }

    //TC : O(n) - O(k)
    static void reverseFirstKElements(Queue<Integer> q,int k){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++){
            st.push(q.poll());
        }

        while(!st.isEmpty()){
            q.offer(st.pop());
        }

        for(int i=0;i<q.size()-k;i++){
            q.offer(q.poll());
        }
    }

    static void printQueue(Queue<Integer> q){
        for(Integer i:q)
            System.out.print(i+" ");
        System.out.println();
    }
}
