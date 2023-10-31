package Trees.Binary_Trees;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Size of Tree is : "+sizeOfBinaryTree(root));
    }

    //TC : O(n) - O(n)
    static int sizeOfBinaryTree(Node root){
        if(root==null) return 0;
        return 1+sizeOfBinaryTree(root.left)+sizeOfBinaryTree(root.right);
    } 
}
