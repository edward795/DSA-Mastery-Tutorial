package Trees.Binary_Trees;

public class height {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("The heightof the binary tree is "+height(root));
    }

    //TC : O(h) - O(h)
    static int height(Node root){
        if(root==null) 
            return 0;
        else 
            return Math.max(height(root.left),height(root.right))+1;
    }
}
