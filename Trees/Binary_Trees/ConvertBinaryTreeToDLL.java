package Trees.Binary_Trees;

public class ConvertBinaryTreeToDLL {
    static Node prev=null;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        Node head=BTToDLL(root);
        System.out.println("The DLL obtained is : ");
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }

    //TC : O(n) - O(h)
    static Node BTToDLL(Node root){
        if(root==null) return root;
        Node head=BTToDLL(root.left);
        if(prev==null){
            head=root;
        }else{
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        BTToDLL(root.right);
        return head;
    }
}
