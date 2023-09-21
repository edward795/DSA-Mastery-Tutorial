package HashMap.HashMap_Implementaion_Java;

import java.util.Arrays;

public class OpenAddressing {
    public static void main(String[] args) {
        MyHash h=new MyHash(3);
        h.insert(4);
        h.insert(12);
        h.insert(2);

        System.out.println("is element 12 present?"+h.search(12));
        h.remove(4);
        System.out.println("is element 4 present?"+h.search(4));
    }
}


class MyHash{
    int[] arr;
    int cap,size;

    MyHash(int c){
        cap=c;
        size=0;
        Arrays.fill(arr,-1);
    }


    int hash(int key){
        return key%cap;
    }

    boolean search(int key){
        int h=hash(key);
        int i=h;
        while(arr[i]!=-1){
            if(arr[i]==key) 
                return true;
            i=(i+1)%cap;

            if(i==h) 
                return false;
        }
        return false;
    }

    boolean insert(int key){
        if(size==cap) 
            return false;
        
        int i=hash(key);

        while(arr[i]!=-1 && arr[i]!=-2 && arr[i]!=key)
            i=(i+1)%cap;

        if(arr[i]==key) 
            return false;
        else{
            arr[i]=key;
            size++;
            return true;
        }
    }

    boolean remove(int key){
        int h=hash(key);
        int i=h;
        while(arr[i]!=-1 && i<cap){
            if(arr[i]==key){
                arr[i]=-2;
                return true;
            }
            i=(i+1)%cap;

            if(i==h) 
                return false; 
        }
        return false;
    }
}