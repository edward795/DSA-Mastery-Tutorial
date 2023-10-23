package Queue.imlementations;

public class LinkedListImpl {
    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        q.dequeue();
        q.printQueue();
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

class MyQueue{
    Node front,rear;
    int size;

    MyQueue(){
        front=rear=null;
        size=0;
    }

    void enqueue(int x){
        Node temp=new Node(x);
        if(front==null){
            front=rear=temp;
        }
        rear.next=temp;
        rear=temp;
    }

    void dequeue(){
        if(front==null) return;
        front=front.next;
        if(front==null) rear=null;
    }

    void printQueue(){
        Node curr=front;
        while(curr!=null){
            System.out.print(curr.data);
            curr=curr.next;
        }
    }
}
