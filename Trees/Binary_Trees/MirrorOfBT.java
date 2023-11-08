package Trees.Binary_Trees;

public class MirrorOfBT {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        Node.printTree(root);
        mirror(root);
        System.out.println();
        Node.printTree(root);
    }

    //TC : O(n) - O(h)
    static void mirror(Node root){
        if(root==null) return;

        if(root.left!=null || root.right!=null){
            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        mirror(root.left);
        mirror(root.right);
    }
}
