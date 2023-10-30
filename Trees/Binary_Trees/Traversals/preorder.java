package Trees.Binary_Trees.Traversals;

import Trees.Binary_Trees.Node;

public class preorder {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        preorder(root);
    }

    //TC : O(n) - O(h) - h = height of binary tree
    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}
