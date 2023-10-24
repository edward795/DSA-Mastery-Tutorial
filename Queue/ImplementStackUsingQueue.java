package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        MyStack st=new MyStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
    }
}

class MyStack{
    Queue<Integer> q1=new ArrayDeque<>();
    Queue<Integer> q2=new ArrayDeque<>();

    MyStack(){

    }

    //TC : O(size)
    void push(int x){
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        q1.offer(x);

        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    int peek(){
        if(!q1.isEmpty()) return q1.peek();
        return -1;
    }

    int pop(){
        if(!q1.isEmpty()) return q1.poll();
        return -1;
    }

    int size(){
        if(!q1.isEmpty()) return q1.size();
        return 0;
    }
}
