package Trees.Binary_Trees;

public class CountSubTreesWithGivenSum {
    static int count=0;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("sum of subtrees with sum 110 is "+countSubTrees(root, 110));
    }

    //TC : O(n) - O(h)
    // static int countSubTrees(Node root,int x){
    //     if(root==null) return 0;
    //     int left=countSubTrees(root.left,x);
    //     int right=countSubTrees(root.right, x); 

    //     if(root.left!=null){
    //         root.data=root.data+root.left.data;
    //     }

    //     if(root.right!=null){
    //         root.data=root.data+root.right.data;
    //     }
    //     if(root.data==x) return 1+left+right;
    //     else return left+right;
    // }
    
    
    //TC : O(n) - O(h)
    static int helper(Node root,int x){
        if(root==null) return 0;
        int left=helper(root.left, x);
        int right=helper(root.right, x);

        int sum=root.data+left+right;
        if(sum==x) count++;
        return sum;
    }

    static int countSubTrees(Node root,int x){
        helper(root, x);
        return count;
    }
}
