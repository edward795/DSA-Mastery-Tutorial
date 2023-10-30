package Trees.Binary_Trees.Traversals;

import Trees.Binary_Trees.Node;

public class postorder {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        postorder(root);
    }

    //TC : O(n) - O(h) - h = height of binary tree
    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
}
