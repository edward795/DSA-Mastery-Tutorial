

public class LinkedListImpl {
    public static void main(String[] args) {
        MyStack st=new MyStack(3);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
    }
}

class MyStack{
    Node head;
    int size;

    MyStack(int s){
        head=null;
        size=s;
    }

    void push(int x){
        Node temp=new Node(x);
        temp.next=head;
        head=temp;
        size++;
    }

    int pop(){
        if(head==null)  
            return Integer.MAX_VALUE;
        int res=head.data;
        head=head.next;
        size--;
        return res;
    }

    int peek(){
        if(head==null) 
            return Integer.MAX_VALUE;
        return head.data;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return (head==null);
    }
}

class Node{
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
    }
}
