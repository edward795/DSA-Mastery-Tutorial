package Trees.Binary_Trees.Traversals;

import Trees.Binary_Trees.Node;


public class Inorder {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        inorder(root);
    }

    //TC : O(n) - O(h) - h = height of binary tree
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
}
