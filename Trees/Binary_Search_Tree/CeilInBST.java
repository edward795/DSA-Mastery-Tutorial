package Trees.Binary_Search_Tree;

public class CeilInBST {
    // static int res=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Node root=Node.getBST();
        // ceil(root,13);
        // System.out.println("The ceil of BST is ? "+res);
        System.out.println("The ceil of BST is ? "+ceil(root, 13));
    }

    //Naive Soln : O(n) - O(h)
    // static void ceil(Node root,int x){
    //     if(root!=null){
    //         ceil(root.left,x);
    //         if(root.data>=x){
    //             res=Math.min(res,root.data);
    //         }
    //         ceil(root.right,x);
    //     }
    // } 

    //TC : O(h) - O(1)
    static int ceil(Node root,int x){
        Node res=null;
        while(root!=null){
            if(root.data==x) 
                return x;
            else if(root.data<x)
                root=root.right;
            else{
                res=root;
                root=root.left;
            }
        }
        return res.data;
    }
}
