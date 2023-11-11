package Trees.Binary_Trees;

public class MaxPathSum {
    static int res=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("max sum path : "+findMaxSum(root));
    }

    //TC : O(n) - O(h)
    static int findMaxSum(Node root){
        helper(root);
        return res;
    }

    static int helper(Node root){
        if(root==null) return 0;
        int m=helper(root.left);
        int n=helper(root.right);

        res=Math.max(res,root.data+m+n);

        if(root.data+m+n<=0) return 0;
        return root.data+Math.max(m,n);
    }
}
