package Dequeue.implementations;


public class CircularArrayImpl{
    public static void main(String[] args){
        MyDequeue dq=new MyDequeue(5);
        dq.insertFront(5);
        dq.insertFront(10);
        dq.insertFront(15);
        dq.printDequeue();
        dq.insertRear(20);
        dq.insertRear(25);
        dq.printDequeue();
        dq.deleteFront();
        dq.printDequeue();
    }
}

class MyDequeue{
    int[] arr;
    int capacity,size,front;

    MyDequeue(int c){
        capacity=c;
        size=0;
        front=0;
        arr=new int[c];
    }

    boolean isFull(){
        return size==capacity;
    }

    boolean isEmpty(){
        return size==0;
    }

    int getFront(){
        if(isEmpty()) return -1;
        return 0;
    }


    int getRear(){
        if(isEmpty()) return -1;
        return (front+size-1);
    }

    void insertFront(int x){
        if(isFull()) return;
        front=(front+capacity-1)%capacity;
        arr[front]=x;
    }

    void deleteFront(){
        if(isEmpty()) return;
        front=(front+1)%capacity;
        size--;
    }

    void insertRear(int x){
        if(isFull()) return;
        int rear=(front+size-1)%capacity;
        rear=(rear+1)%capacity;
        arr[rear]=x;
        size++;
    }

    void deleteRear(){
        if(isEmpty()) return;
        size--;
    }

    void printDequeue(){
        for(int i=0;i<size;i++) 
            System.out.print(arr[i]+" ");
    }
}