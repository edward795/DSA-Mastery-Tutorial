package Queue.imlementations;

public class ArrayImpl{
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

class MyQueue{
    int[] arr;
    int size,cap;

    MyQueue(int c){
        cap=c;
        size=0;
        arr=new int[c];    
    }

    boolean isFull(){
        return (size==cap);
    }

    boolean isEmpty(){
        return (size==0);
    }

    int getFront(){
        if(isEmpty()) 
            return -1;
        return 0;
    }

    int getRear(){
        if(isEmpty())
            return -1;
        return size-1;
    }

    //TC : O(1)
    void enqueue(int x){
        if(isFull()) return;
        arr[size]=x;
        size++;
    }

    //TC : O(n)
    void dequeue(){
        if(isEmpty()) return;
        for(int i=0;i<size-1;i++)
            arr[i]=arr[i+1];
        size--;
    }


    void printQueue(){
        for(int i=0;i<size;i++) 
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}