package Trees.Binary_Trees;

public class BinaryTreeToCDLL {
    static Node head=null,prev=null;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        Node head=binaryTreeToCDLL(root);

        Node curr=head;
        while(curr.right!=head){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }

    //TC : O(n) - O(h)
    static Node binaryTreeToCDLL(Node root){
        if(root==null) return null;
        binaryTreeToCDLL(root.left);
        if(prev==null){
            head=root;
        }else{
            prev.right=root;
            root.left=prev;
        } 
        prev=root;
        binaryTreeToCDLL(root.right);
        head.left=prev;
        prev.right=head;
        return head;
    }
}


