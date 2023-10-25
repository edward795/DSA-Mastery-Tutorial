package Dequeue.implementations;

import java.util.Deque;

public class ArrayImpl {
    public static void main(String[] args) {
        MyDequeue dq=new MyDequeue(5);
        dq.insertFront(10);
        dq.insertFront(20);
        dq.insertFront(30);
        dq.printDequeue();
        
        dq.insertRear(40);
        dq.printDequeue();

        dq.deleteFront();
        dq.printDequeue();
    }
}

class MyDequeue{
    int[] arr;
    int size,cap;

    MyDequeue(int c){
        arr=new int[c];
        size=0;
        cap=c;
    }

    boolean isFull(){
        return size==cap;
    }

    boolean isEmpty(){
        return size==0;
    }

    //TC : O(n)
    void insertFront(int x){
        if(isFull()) return;
        for(int i=size-1;i>=0;i--) 
            arr[i+1]=arr[i];
        arr[0]=x;
        size++;
    }

    void insertRear(int x){
        if(isFull()) return;
        arr[size++]=x;
    }

    //TC : O(n)
    void deleteFront(){
        if(isEmpty()) return;
        for(int i=0;i<size;i++)
            arr[i]=arr[i+1];
        size--;
    }

    void deleteRear(){
        if(isEmpty()) return;
        size--;
    }

    int getFront(){
        if(isEmpty()) return -1;
        return 0;
    }

    int getRear(){
        if(isEmpty()) return -1;
        return size-1;
    }

    void printDequeue(){
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
