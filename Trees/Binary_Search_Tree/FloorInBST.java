package Trees.Binary_Search_Tree;

public class FloorInBST {
    // static int res=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node root=Node.getBST();    
        // floor(root,32);
        // System.out.println("The floor value of BST is "+res);
        System.out.println("The floor of the BST is "+floor(root,39));
    }

    //Naive Soln : O(n) - O(h)
    // static void floor(Node root,int x){
    //     if(root!=null){
    //         floor(root.left,x);
    //         if(root.data<=x){
    //             res=Math.max(res,root.data);
    //         }
    //         floor(root.right,x);
    //     }
    // }

    //TC : O(h) - O(1)
    static int floor(Node root,int x){
        Node res=null;
        while(root!=null){
            if(root.data==x) 
                return x;
            else if(root.data>x) 
                root=root.left;
            else {
                res=root;
                root=root.right;
            }
        } 
        return res.data;
    }
}
