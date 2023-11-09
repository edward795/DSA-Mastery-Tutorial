package Trees.Binary_Trees;

import java.util.HashSet;

public class VerticalWidthOfBT {

    static int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("The vertical widthof BT is "+verticalWidth(root));
    }

    // static void getVerticalHeightUtil(Node root,int curr){
    //     if(root==null) return;
    //     getVerticalHeightUtil(root.left, curr-1);
    //     if(curr<min) min=curr;
    //     if(curr>max) max=curr;
    //     getVerticalHeightUtil(root.right, curr+1);
    // }

    // //TC  : O(n) - O(h)
    // static int verticalWidth(Node root){
    //     getVerticalHeightUtil(root, 0);
    //     return Math.abs(min)+max+1;
    // }

    //TC : O(n) - O(w) - using hashset
    static void verticalUtil(Node root,HashSet<Integer> set,int curr){
        if(root==null) return;
        set.add(curr);
        verticalUtil(root.left, set, curr-1);
        verticalUtil(root.right, set, curr+1);
    }

    static int verticalWidth(Node root){
        HashSet<Integer> h=new HashSet<>();
        verticalUtil(root, h, 0);
        return h.size();
    }
}
