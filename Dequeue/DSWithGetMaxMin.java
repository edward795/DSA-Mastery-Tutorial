package Dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class DSWithGetMaxMin {
    public static void main(String[] args) {
        MyDS ds=new MyDS();
        ds.insertMin(10);
        ds.insertMin(20);
        ds.insertMax(70);
        ds.insertMax(90);
        System.out.println(ds.extractMax());
        System.out.println(ds.extractMin());
    }
}

class MyDS{
    Deque<Integer> dq;

    MyDS(){
        dq=new LinkedList<>();
    }

    int getMin(){
        return dq.peekFirst();
    }

    int getMax(){
        return dq.peekLast();
    }

    void insertMin(int x){
        dq.offerFirst(x);
    }

    void insertMax(int x){
        dq.offerLast(x);
    }

    int extractMin(){
        return dq.pollFirst();
    }

    int extractMax(){
        return dq.pollLast();
    }
}
