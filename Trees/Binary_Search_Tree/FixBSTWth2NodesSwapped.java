package Trees.Binary_Search_Tree;
import java.util.*;

public class FixBSTWth2NodesSwapped {

    static Node prev=null,first=null,second=null;
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println(root.data);
        Node.inorder(root); 
        System.out.println();
        int temp=root.left.left.left.data;
        root.left.left.left.data=root.left.left.data;
        root.left.left.data=temp;
        Node.inorder(root);

        fixSwapped(root);
        int aux=first.data;
        first.data=second.data;
        second.data=aux;

        System.out.println();
        Node.inorder(root);
    }


    //Naive Soln : O(n) - O(n)
    // static void fixSwapped(Node root){
    //     ArrayList<Node> arr=new ArrayList<>();
    //     Inorder(root,arr);
    //     Node prev=null,first=null,second=null;
    //     for(int i=0;i<arr.size();i++){
    //         if(prev!=null && arr.get(i).data<prev.data){
    //             if(first==null) 
    //                 first=prev;
    //             second=arr.get(i);
    //         }
    //         prev=arr.get(i);
    //     }

    //     if(first!=null && second!=null){
    //         int temp=first.data;
    //         first.data=second.data;
    //         second.data=temp;
    //     }
    // }


    // static void Inorder(Node root,ArrayList<Node> arr){
    //     if(root!=null){
    //         Inorder(root.left,arr);
    //         arr.add(root);
    //         Inorder(root.right,arr);
    //     }
    // }

    //Efficient Soln : O(n) - O(h)
    static void fixSwapped(Node root){
        if(root==null) return;
        fixSwapped(root.left);
        if(prev!=null && root.data<prev.data){
            if(first==null)
                first=prev;
            second=root;
        }
        prev=root;
        fixSwapped(root.right);
    }

}
