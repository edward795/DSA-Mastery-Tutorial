package Trees.Binary_Trees;

public class MaxDiffBetweenNodeAndParent {
    static Integer res=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("The max diff of nodes "+maxDiff(root));
    }

    //TC  : O(n) - O(h)
    static int maxDiff(Node root){
        helper(root);
        return res;
    }

    static int helper(Node root){
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) return root.data;
        int left=helper(root.left);
        int right=helper(root.right);
        
        int min=Math.min(left,right);
        res=Math.max(res,root.data-min);
        return Math.min(root.data,min);
    }   
}
