package Trees.Binary_Trees;

import java.util.ArrayList;

public class LeftViewOfBT {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("The left view is "+leftView(root));
    }

    //TC : O(n) - O(h)
    static ArrayList<Integer> leftView(Node root){
        ArrayList<Integer> al = new ArrayList<>();
        helper(root,al,0);
        return al;
    }

    static void helper(Node root,ArrayList<Integer> al,int level){
        if(root==null) return;
        if(al.size()==level) al.add(root.data);
        helper(root.left,al,level+1);
        helper(root.right,al,level+1);
    }
}
