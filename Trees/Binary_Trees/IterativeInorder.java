package Trees.Binary_Trees;

import java.util.Stack;

public class IterativeInorder {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        iterativeInorder(root);
    }

    //TC : O(n) - O(h)
    static void iterativeInorder(Node root){
        if(root==null) return;
        Stack<Node> st=new Stack<Node>();
        
        Node curr=root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }

            curr=st.pop();
            System.out.print(curr.data+" ");
            curr=curr.right;
        }
    }
}
