package Binary_Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No2RepeatedChars {
    public static void main(String[] args) {
        String res="geeksforgeeks";
        System.out.println("New string is "+removeAdjacents(res));
    }

    //TC : O(nlogn)
    static String removeAdjacents(String str){
        int n=str.length();
        PriorityQueue<Key> pq=new PriorityQueue<>(new KeyComparator());

        int counter[]=new int[26];
        for(int i=0;i<n;i++){ counter[str.charAt(i)-'a']++; };

        Key prev=new Key('#',-1);
        
        for(char i='a';i<='z';i++){
            int val=i-'a';
            if(counter[val]>0)
                pq.offer(new Key(i,counter[val]));
        }

        StringBuffer res=new StringBuffer();
        while(!pq.isEmpty()){
            Key k=pq.poll();
            res.append(k.ch);
            if(prev.freq>0)
                pq.add(prev);

            (k.freq)--;
            prev=k;
        }
        return res.toString();
    }

}
class Key{
    char ch;
    int freq;

    Key(char c,int f){
        ch=c;
        freq=f;
    }
}

class KeyComparator implements Comparator<Key>{
    public int compare(Key k1,Key k2){
        return k1.freq-k2.freq;
    }
}
