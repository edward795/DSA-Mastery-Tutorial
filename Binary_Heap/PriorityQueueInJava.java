package Binary_Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueInJava {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(15);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(10);
        pq1.add(20);
        pq1.add(30);
        pq1.add(40);
        pq1.add(50);
        System.out.println(pq1.peek());
    }
}
