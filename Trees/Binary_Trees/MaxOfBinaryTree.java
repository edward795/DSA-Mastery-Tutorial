package Trees.Binary_Trees;

public class MaxOfBinaryTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Max of Binary Tree : "+MaxOfBinaryTree(root));
    }

    //TC : O(n) - O(h)
    static int MaxOfBinaryTree(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(MaxOfBinaryTree(root.left),MaxOfBinaryTree(root.right)));
    }
}
