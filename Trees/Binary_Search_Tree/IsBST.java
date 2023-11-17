package Trees.Binary_Search_Tree;

public class IsBST {
    static int prev=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=Node.getBST();
        // System.out.println("Is this a valid BST ? "+isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println("Is this a valid BST ? "+isBST(root));
    }

    //Naive Soln : O(n) - O(h)
    // static boolean isBST(Node root,int min,int max){
    //     if(root==null) return true;

    //     return (root.data>min && root.data<max && isBST(root.left,min,root.data) && isBST(root.right,root.data,max));
    // }

    //Efficient Soln : O(n) - O(h)
    static boolean isBST(Node root){
        if(root==null) return true;
        if(isBST(root.left)==false) return false;
        if(root.data<=prev) return false;
        prev=root.data;
        return isBST(root.right);
    }

}



