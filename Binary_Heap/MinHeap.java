package Binary_Heap;

public class MinHeap{
    int arr[];
    int size;
    int capacity;

    MinHeap(int c){
        arr=new int[c];
        capacity=c;
        size=0;
    }

    int left(int i){ return (2*i+1); }
    int right(int i){ return (2*i+2); }
    int parent(int i){ return (i-1)/2; }
}