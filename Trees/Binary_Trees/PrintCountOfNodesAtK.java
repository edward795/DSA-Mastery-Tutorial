package Trees.Binary_Trees;

import java.util.HashMap;
import java.util.HashSet;

public class PrintCountOfNodesAtK {
    static HashMap<Integer,Node> hm=new HashMap<>();
    static HashSet<Node> s=new HashSet<>();
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Count of nodes at level 2 from leaf node is "+getCount(root, 1));
    }


    //TC : O(n) -O(h)
    static int getCount(Node root,int level){
        helper(root,0,level);
        return s.size();
    }

    static void helper(Node root,int height,int level){
        if(root==null) return;

        if(height>=level && root.left==null && root.right==null){
            s.add(hm.get(height-level));
        }
        hm.put(height,root);
        helper(root.left,height+1,level);
        helper(root.right,height+1,level);
    }

}
