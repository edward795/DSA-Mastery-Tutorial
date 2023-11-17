package Trees.Binary_Search_Tree;

public class KthSmallest {
    static int count=0;
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println(printKth(root,3).data);
    }


    //TNaive Soln : O(n) - O(h)
    // private static Node printKth(Node root, int k) {
    //     if(root!=null){
    //         Node left=printKth(root.left, k);
    //         if(left!=null) 
    //             return left;
    //         count++;
    //         if(count==k){ 
    //            return root;
    //         }
    //         return printKth(root.right, k);
    //     }
    //     return null;
    // }

    //Efficent Soln : O(h) - O(h)
    private static Node printKth(Node root, int k) {
        if(root==null) return null;
        
        int count=root.lcount+1;
        if(count==k) 
            return root;
        
        if(count>k) 
            return printKth(root.left, k);

        return printKth(root.right, k-count-1);
    }
}

