package LinkedList;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheImplementation {
    public static void main(String[] args) {
        LRUCache cache=new LRUCache(4);
        cache.putElementInCache(4);
        cache.putElementInCache(9);
        cache.putElementInCache(12);
        cache.putElementInCache(18);
        cache.printCache();
        cache.getElementFromCache(9);
        cache.printCache();
        cache.getElementFromCache(4);
        cache.printCache();
        cache.getElementFromCache(55);
        cache.printCache();
    }
}


class LRUCache{
    int capacity;
    int counter;
    int[] arr;

    LRUCache(int capacity){
        this.capacity=capacity;
        counter=0;
        arr=new int[capacity];
    }

    int getElementFromCache(int key){
        for(int i=0;i<capacity;i++){
            if(arr[i]==key){
                int temp=arr[0];
                arr[0]=key;
                arr[i]=temp;
                return key;
            }
        }
        return -1;
    }

    void putElementInCache(int key){
        for(int i=0;i<capacity;i++){
            if(arr[i]==key){
                if(counter<capacity){
                    int temp=arr[0];
                    arr[0]=key;
                    arr[i]=temp;
                    counter++;
                }else if(capacity==counter){
                    //remove last ele in array : O(n)
                    for(int j=0;j<capacity-1;j++){
                        arr[j+1]=arr[j];
                    }
                    arr[0]=key;
                }
            }
        }
        if(counter<capacity){
            int temp=arr[0];
            arr[0]=key;
            arr[counter++]=temp;
        }else if(capacity==counter){
            //remove last ele n array : O(n)
            for(int j=0;j<capacity-1;j++){
                arr[j+1]=arr[j];
            }
            arr[0]=key;
        }
    }

    void printCache(){
        for(int i=0;i<capacity;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

//impl using Doubly Linked List & Hashtable
// class LRUCache{
//     private Deque<Integer> doublyQueue;
//     private HashSet<Integer> set;
//     int capacity;

//     LRUCache(int capacity){
//         this.capacity=capacity;
//         doublyQueue=new LinkedList<>();
//         set=new HashSet<>();
//     }


//      int getElementFromCache(int key){
//         if(set.contains(key)){
//             doublyQueue.remove(key);
//             doublyQueue.addFirst(key);
//             return key;
//         }
//         return -1;
//     }

//     void putElementInCache(int key){
//         if(set.contains(key)){
//             doublyQueue.remove(key);
//             doublyQueue.addFirst(key);
//         }else{
//             if(doublyQueue.size()==4){
//                 doublyQueue.removeLast();
//                 set.remove(key);
//             }
//             doublyQueue.addFirst(key);
//             set.add(key);
//         }
//     }

//     void printCache(){
//         Iterator<Integer> it =doublyQueue.iterator();
//         while(it.hasNext()){
//             System.out.print(it.next()+" ");
//         }
//         System.out.println();
//     }
// }