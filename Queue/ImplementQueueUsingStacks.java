package Queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        System.out.println(q.dequeue());
        q.printQueue();
    }
}

class MyQueue{
    Stack<Integer> s1;
    Stack<Integer> s2;

    MyQueue(){
        s1=new Stack<Integer>();
        s2=new Stack<Integer>();
    }

    void enqueue(int x){
        s1.push(x);
    }

    int dequeue(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int x=s2.pop();
        
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return x;
    }


    void printQueue(){
        for(Integer i:s1)
            System.out.print(i+" ");
        System.out.println();
    }
}
