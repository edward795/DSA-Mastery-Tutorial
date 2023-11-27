package Trees.Binary_Search_Tree;

public class FindLeastAbsoluteDiff{
    static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println(minDiff(root, 3));
    }

    //TC : O(h) - O(h) - recurive
    // static int minDiff(Node root,int k){
    //     if(root==null) return Integer.MAX_VALUE;
    //     if(root.data==k) return 0;

    //     if(root.data<k) 
    //         return Math.min(minDiff(root.right, k),Math.abs(root.data-k));
    //     else 
    //         return Math.min(minDiff(root.left, k),Math.abs(root.data-k));
    // }

    //TC : O(h) - O(h)
    static int minDiff(Node root,int k){
        int ans=Math.abs(root.data-k);
        while(root!=null){
            ans=Math.abs(root.data-k);
            if(root.data<k){
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return ans;
    }

}