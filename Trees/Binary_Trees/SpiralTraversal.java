package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversal{
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        spiralTraversal(root);
    }

    //Method 1 : TC : O(n) - O(h)
    // static void spiralTraversal(Node root){
    //     Queue<Node> q=new LinkedList<>();
    //     Stack<Integer> st=new Stack<>();
    //     q.add(root);
    //     boolean flag=false;
    //     while(!q.isEmpty()){
    //         int count=q.size();
    //         for(int i=0;i<count;i++){
    //             Node curr=q.poll();
    //             if(flag)
    //                 st.push(curr.data);
    //             else 
    //                 System.out.print(curr.data+" ");
                
    //                 if(curr.left!=null) q.add(curr.left);
    //                 if(curr.right!=null) q.add(curr.right);
    //         }
    //         if(flag){
    //             while(!st.isEmpty()){
    //                 System.out.print(st.pop()+" ");
    //             }
    //         }
    //         System.out.println();
    //         flag=!flag;
    //     }
    // }


    static void spiralTraversal(Node root){
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();

        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
            while(!st1.isEmpty()){
                Node curr=st1.pop();
                if(curr.left!=null) st2.push(curr.left);
                if(curr.right!=null) st2.push(curr.right);
                System.out.print(curr.data+" ");
            }
            System.out.println();
            while(!st2.isEmpty()){
                Node curr=st2.pop();
                if(curr.left!=null) st1.push(curr.left);
                if(curr.right!=null) st1.push(curr.right);
                System.out.print(curr.data+" ");
            }
            System.out.println();
        }
    }
}