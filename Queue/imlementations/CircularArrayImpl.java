package Queue.imlementations;

public class CircularArrayImpl {
    public static void main(String[] args) {
        MyQueue q=new MyQueue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();
        q.dequeue();
        q.printQueue();
    }
}

//TC - All ops are O(1)
class MyQueue{
    int[] arr;
    int front,cap,size;

    MyQueue(int c){
        arr=new int[cap];
        front=0;
        cap=c;
        size=0;
    }

    boolean isFull(){
        return size==cap;
    }

    boolean isEmpty(){
        return size==0;
    }

    int getFront(){
        if(isEmpty()) return -1;
        return front;
    }

    int getRear(){
        if(isEmpty()) return -1;
        return (front+size-1)%cap;
    }

    void enqueue(int x){
        if(isFull()) return;
        int rear=getRear();
        rear=(rear+1)%cap;
        arr[rear]=x;
        size++;
    }

    void dequeue(){
        if(isEmpty()) return;
        front=(front+1)%cap;
        size--;
    }

    void printQueue(){
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
