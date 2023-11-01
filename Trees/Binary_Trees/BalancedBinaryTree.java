package Trees.Binary_Trees;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        // System.out.println("Is the tree balanced ?  "+isBalanced(root));
        System.out.println("Is the tree balanced ?  "+ (isBalanced(root)>=0?true:false));
    }

    //Naive Soln : O(n^2) - O(h)
    // static boolean isBalanced(Node root){
    //     if(root==null) return true;

    //     int lh=height(root.left);
    //     int rh=height(root.right);

    //     return (Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right));
    // }
    
    // //TC : O(n)
    // static int height(Node root){
    //     if(root==null) return 0;
    //     return Math.max(height(root.left),height(root.right))+1;
    // }

    //TC : O(n) - O(h)
    static int isBalanced(Node root){
        if(root==null) return 0;
        int lh=isBalanced(root.left);
        if(lh==-1) return -1;
        int rh=isBalanced(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh)>1)
            return -1;
        else 
            return Math.max(lh,rh)+1;
    }
}
