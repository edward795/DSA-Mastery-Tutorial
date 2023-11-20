package Trees.Binary_Search_Tree;

import LinkedList.utils.LinkedList;
import java.util.*;
public class VerticalTraversalOfBST {
    public static void main(String[] args) {
        Node root=Node.getBST();
        verticalOrder(root);
    }

    //TC : O(n) - O(h)
    static void verticalOrder(Node root){
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,ArrayList<Integer>> mp=new TreeMap<>();
        q.add(new Pair(root,0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            Node curr=p.node;
            int hd=p.hd;

            if(mp.containsKey(hd))
                mp.get(hd).add(curr.data);
            else{
                ArrayList<Integer> al =new ArrayList<>();
                al.add(curr.data); 
                mp.put(hd,al);
            }

            if(curr.left!=null) q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null) q.add(new Pair(curr.right,hd+1));
        }

        for(Map.Entry<Integer,ArrayList<Integer>> p:mp.entrySet()){
            ArrayList<Integer> al=p.getValue();
            for(int x:al) 
                System.out.print(x+" ");
            System.out.println();
        }

    }
}

class Pair{
    Node node;
    int hd;

    Pair(Node n,int h){
        node=n;
        hd=h;
    }
}
