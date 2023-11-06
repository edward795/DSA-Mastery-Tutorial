package Trees.Binary_Trees;

import java.util.Stack;

public class IterativePreorder {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        iterativePreorder(root);
    }

    //TC : O(n) - O(h)
    // static void iterativePreorder(Node root){
    //     if(root==null) return;
    //     Stack<Node> st=new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         Node curr=st.pop();
    //         System.out.print(curr.data+" ");
    //         if(curr.left!=null) st.push(curr.left);
    //         if(curr.right!=null) st.push(curr.right);
    //     }
    // }

    //TC : O(n) - O(h)
    static void iterativePreorder(Node root){
        if(root==null) return;
        Stack<Node> st=new Stack<>();
        Node curr=root;

        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                System.out.print(curr.data+" ");
                if(curr.right!=null)
                    st.push(curr.right);
                curr=curr.left;
            }


            if(!st.isEmpty()) 
                curr=st.pop();
        }
    }
}
