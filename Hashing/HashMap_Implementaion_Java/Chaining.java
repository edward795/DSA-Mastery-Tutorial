package Hashing.HashMap_Implementaion_Java;
import java.util.*;


public class Chaining {
    public static void main(String[] args) {
            MyHash h=new MyHash(5);
            h.insert(5);
            h.insert(7);
            h.insert(12);
            h.insert(15);
            System.out.println("Is element 7 rsent in the hash:"+h.search(7));
    }
}

class MyHash{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    MyHash(int b){
        BUCKET=b;
        table=new ArrayList<LinkedList<Integer>>();

        for(int i=0;i<b;i++){
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int key){
        int i=key%BUCKET;
        table.get(i).add(key);
    }

    void remove(int key){
        int i=key%BUCKET;
        table.get(i).remove(key);
    }

    boolean search(int key){
        int i=key%BUCKET;
        return table.get(i).contains(key);
    }
}