package Trees.Binary_Trees;

import java.util.HashMap;

public class MaxSumOfNonAdjacentNodes {
    static HashMap<Node,Integer> h=new HashMap<>();
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Max non adjacent nodes  sum is "+h.get(root));
    }

    //TC : O(n) - O(h)
    static int getMaxSumOfNonAdjacent(Node root){
        if(root==null) return 0;
        if(h.containsKey(root)) return h.get(root);

        int inclusive=root.data;
        if(root.left!=null)
            inclusive+=getMaxSumOfNonAdjacent(root.left.left)+getMaxSumOfNonAdjacent(root.left.right);

        if(root.right!=null)
            inclusive+=getMaxSumOfNonAdjacent(root.right.left)+getMaxSumOfNonAdjacent(root.right.right);

        int exclusive=getMaxSumOfNonAdjacent(root.left)+getMaxSumOfNonAdjacent(root.right);
        h.put(root,Math.max(exclusive,inclusive));
        return Math.max(inclusive,exclusive);
    }
}
