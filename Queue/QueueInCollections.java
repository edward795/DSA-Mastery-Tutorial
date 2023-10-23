package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueInCollections {
    public static void main(String[] args) {
        //Queue<Integer> q=new LinkedList<>();
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        q.poll();
        System.out.println(q.size());
        System.out.println(q.peek());

        System.out.println(q.element());
        q.add(12);
       System.out.println(q.remove());
    }
}
