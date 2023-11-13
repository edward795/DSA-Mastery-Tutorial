package Trees.Binary_Search_Tree;

public class DeleteInBST {
    public static void main(String[] args) {
        Node root=Node.getBST();
        Node.inorder(root);
        root=delNode(root, 35);
        System.out.println();
        Node.inorder(root);
    }

    //TC : O(n) - O(h)
    static Node delNode(Node root,int x){
        if(root==null) return null;
        if(root.data>x) 
            root.left=delNode(root.left, x);
        else if(root.data<x)
            root.right=delNode(root.right, x);
        else{
            if(root.left==null) 
                return root.right;
            else if(root.right==null) 
                return root.left;
            else{
                Node succ=getSucc(root);
                root.data=succ.data;
                root.right=delNode(root.right,succ.data);
            }
        }
        return root;
    }

   static Node getSucc(Node root){
        Node curr=root.right;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
}
