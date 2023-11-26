package Trees.Binary_Search_Tree;

import java.util.*;

public class BottomViewBinaryTree {
    public static void main(String[] args) {
        Node tree=Node.getBST();
        bottomView(tree);
    }

    //TC : O(n) - O(h)
    static void bottomView(Node root){
       Queue<Pair> q=new ArrayDeque<>();
       Map<Integer,Pair> mp=new TreeMap<>();

       q.add(new Pair(root,0));
       while(!q.isEmpty()){
           Pair p=q.poll();
           Node curr=p.node;
           int hd=p.hd;
           if(mp.containsKey(hd))
                mp.get(hd).add(curr);

            if(curr.left!=null) q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null) q.add(new Pair(curr.right,hd+1));
       }

       for(Map.Entry<Integer,Pair> p:mp.entrySet()) 
            System.out.println(p.getValue().node.data+" ");
    }
}

class Pair{
    Node node;
    int hd;

    Pair(Node n,int h){
        node=n;
        hd=h;
    }

    public void add(Node curr) {
    }
}
