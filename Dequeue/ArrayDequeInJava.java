package Dequeue;

import java.util.ArrayDeque;

public class ArrayDequeInJava {
    public static void main(String[] args) {

        //ArrayDeque as Stack
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        dq.push(10);
        dq.push(20);
        dq.push(30);
        System.out.println(dq);
        System.out.println(dq.peek());
        System.out.println(dq.pop());
        System.out.println(dq);

        //ArrayDeque as Queue
        ArrayDeque<Integer> dq1=new ArrayDeque<>();
        dq1.offer(10);
        dq1.offer(20);
        dq1.offer(30);
        System.out.println(dq1);
        System.out.println(dq1.peek());
        System.out.println(dq1.poll());
        System.out.println(dq1);

        //ArrayDeque as Deque
        //Functions with exception handling
        ArrayDeque deq=new ArrayDeque<>();
        deq.offerFirst(10);
        deq.offerFirst(20);
        deq.offerFirst(30);
        deq.offerLast(40);
        deq.offerLast(50);
        deq.offerLast(60);
        System.out.println(deq);
        deq.pollFirst();
        System.out.println(deq);
        deq.pollLast();
        System.out.println(deq);
        System.out.println(deq.peekFirst());
        System.out.println(deq.peekLast());

        //Functions without exception handling
        ArrayDeque dq3=new ArrayDeque<>();
        dq3.addFirst(10);
        dq3.addFirst(20);
        dq3.addFirst(30);
        dq3.addLast(40);
        dq3.addLast(50);
        dq3.addLast(60);
        System.out.println(dq3);
        dq3.removeFirst();
        System.out.println(dq3);
        dq3.removeLast();
        System.out.println(dq3);
        System.out.println(dq3.getFirst());
        System.out.println(dq3.getLast());
    }
}
