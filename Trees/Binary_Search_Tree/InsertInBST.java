package Trees.Binary_Search_Tree;

public class InsertInBST {
    public static void main(String[] args) {
        int[] arr=new int[]{20,15,30,40,50,12,18,35,80,7};
        Node root=null;
        for(Integer i :arr)
            root=insert(root,i);
        Node.inorder(root);
            
    }


    //TC : O(h) - O(h), for skewed - O(n)
    // static Node insert(Node root,int x){
    //     Node temp=new Node(x);
    //     if(root==null) return temp;
    //     if(root.data>x){
    //         root.left=insert(root.left,x);
    //     }else if(root.data<x){
    //         root.right=insert(root.right,x);
    //     }
    //     return root;
    // }
    
    //TC : O(h) - O(1)
    static Node insert(Node root,int x){
        Node temp=new Node(x);
        Node parent=null,curr=root;
        while(curr!=null){
            parent=curr;
            if(curr.data>x)
                curr=curr.left;
            else if(curr.data<x)
                curr=curr.right;
            else 
                return root;
        }

        if(parent==null)
            return temp;

        if(parent.data>x)
            parent.left=temp;
        else
            parent.right=temp;
        return root;
    }
}
