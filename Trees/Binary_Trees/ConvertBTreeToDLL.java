package Trees.Binary_Trees;

import java.util.ArrayList;

public class ConvertBTreeToDLL {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        Node head=bTreeToDLL(root);

        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.right;
        }
    }

    static void inorder(Node root,ArrayList<Node> al){
        if(root!=null){
            inorder(root.left,al);
            al.add(root);
            inorder(root.right,al);
        }
    }

    //TC : O(n) - O(h)
    static Node bTreeToDLL(Node root){
        ArrayList<Node> al=new ArrayList<>();
        inorder(root, al);
        Node head=al.get(0);
        Node prev=head;

        for(int i=1;i<al.size();i++){
            Node curr=al.get(i);
            prev.right=curr;
            curr.left=prev;
            prev=curr;
        }
        return head;
    }
}


