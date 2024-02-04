package Greedy_Algorithms;

import java.util.PriorityQueue;

public class HuffmanCoding {
    public static void main(String[] args) {
        char[] arr=new char[]{'a','b','e','b','f'};
        int[] freq=new int[]{10,50,40,50,80};
        printHCodes(arr, freq);
    }

    static void printCodes(Node root,String str){
        if(root==null) return;

        if(root.ch!='$'){
            System.out.println(root.ch+" "+str);
            return;
        }
        printCodes(root.left, str+"0");
        printCodes(root.right, str+"1");
    }

    static void printRec(Node root,String s){
        if(root.ch!='$'){
            System.out.println(root.ch+" "+s);
            return;
        }
        printRec(root.left, s+"0");
        printRec(root.right, s+"1");
    }

    static void printHCodes(char[] arr,int[] freq){
        PriorityQueue<Node> pq=new PriorityQueue<>((n1,n2)->n1.freq-n2.freq);
        for(int i=0;i<arr.length;i++){
            pq.add(new Node(arr[i],freq[i],null,null));
        }

        while(pq.size()>1){
            Node l=pq.poll();
            Node r=pq.poll();
            pq.add(new Node('$',l.freq+r.freq,l,r));
        }
        printRec(pq.peek(), " ");
    }
}

class Node{
    char ch;
    int freq;
    Node left,right;

    Node(char ch,int freq,Node left,Node right){
        this.ch=ch;
        this.freq=freq;
        this.left=left;
        this.right=right;
    }
}
