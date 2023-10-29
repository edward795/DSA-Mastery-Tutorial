package Dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DequeueInJava {
    public static void main(String[] args) {

        //LinkedList as Stack
        LinkedList<Integer> st=new LinkedList<>();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st.peek());

        //LinkedList as Queue
        Queue<Integer> q=new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q);
        System.out.println(q.peek());

        //LinkedList as Deque
        //Funtions with exception handling
        Deque<Integer>dq=new LinkedList<>();
        dq.offerFirst(10);
        dq.offerFirst(20);
        dq.offerFirst(30);
        System.out.println(dq);
        dq.offerLast(40);
        dq.offerLast(50);
        System.out.println(dq);
        dq.pollFirst();
        System.out.println(dq);
        dq.pollLast();
        System.out.println(dq);

        //Funtions without exception handling
        dq.addFirst(5);
        dq.addFirst(2);
        System.out.println(dq);
        dq.addLast(40);
        dq.addLast(50);
        System.out.println(dq);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);

        //iterating a deque
        Iterator it=dq.iterator();
        while(it.hasNext())
            System.out.print(it.next()+" ");

        System.out.println();

        //iterating in backward direction
        Iterator itRev=dq.descendingIterator();
        while(itRev.hasNext())
            System.out.print(itRev.next()+" ");

    }
}
