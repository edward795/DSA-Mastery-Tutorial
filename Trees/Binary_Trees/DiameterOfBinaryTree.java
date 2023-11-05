package Trees.Binary_Trees;

public class DiameterOfBinaryTree {
    static int d=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        // System.out.println("diameter of BT is "+diameter(root));
        diameter(root);
        System.out.println("diameter of BT is "+d);
    }

    // static int height(Node root){
    //     if(root==null) return 0;
    //     return 1+Math.max(height(root.left),height(root.right));
    // }

    //Naive Soln  : O(n^2)
    // static int diameter(Node root){
    //     if(root==null) return 0;
    //     int d1=1+height(root.left)+height(root.right);

    //     int d2=diameter(root.left);
    //     int d3=diameter(root.right);

    //     return Math.max(d1,Math.max(d2,d3));
    // }

    //Efficient Soln : O(n) -O(h)
    static int diameter(Node root){
        if(root==null) return 0;
        int lh=diameter(root.left);
        int rh=diameter(root.right);

        d=Math.max(d,1+lh+rh);
        return 1+Math.max(lh,rh);
    }
}
