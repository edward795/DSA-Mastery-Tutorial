package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CustomFunctionsInDeque {
    public static void main(String[] args) {
        Deque<Integer> dq=new ArrayDeque<>();
        dq.addFirst(10);
        dq.addFirst(20);
        dq.addFirst(30);
        dq.addFirst(40);
        dq.addFirst(50);
        System.out.println(dq);
        dq.addLast(60);
        dq.addLast(70);
        dq.addLast(80);
        dq.addLast(90);
        dq.addLast(100);
        System.out.println(dq);
        eraseAt(dq,3);
        System.out.println(dq);
        eraseInRange(dq,0,3);
        System.out.println(dq);
        eraseAll(dq);
        System.out.println();
    }

    static void eraseAt(Deque<Integer> dq,int x){
        Iterator it=dq.iterator();
        for(int i=0;i<=x;i++){
            it.next();
        }
        it.remove();
    }

    static void eraseInRange(Deque<Integer> dq,int start,int end){
        if(start==end) return;
        Iterator it=dq.iterator();
        for(int i=0;i<start;i++)
            it.next();

        for(int i=start;i<end;i++){
            it.next();
            it.remove();
        }
    }

    static void eraseAll(Deque<Integer> dq){
        while(!dq.isEmpty()){
            dq.poll();
        }
    }
}
