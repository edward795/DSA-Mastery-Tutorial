package Dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeueInJava {
    public static void main(String[] args) {

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
