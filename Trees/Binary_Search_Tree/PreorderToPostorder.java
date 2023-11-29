package Trees.Binary_Search_Tree;

import Trees.Binary_Trees.Traversals.postorder;

public class PreorderToPostorder {
    static int i=0;
    public static void main(String[] args) {
        int[] pre_order=new int[]{1,2,3,4,5};
        //post_order(pre_order);
        Node root=post_order(pre_order);
        Node.inorder(root);
    }

    //Naive Soln : O(n)
    // static void post_order(int[] arr){
    //     Node root=new Node(arr[0]);
    //     for(int i=1;i<arr.length;i++){
    //         root=insertNode(root, arr[i]);
    //     }
    //     Node.inorder(root);
    // }


    // static Node insertNode(Node root,int x){
    //     Node temp=new Node(x);
    //     if(root==null) return temp; 
    //     if(root.data<x){
    //         root.right=insertNode(root.right,x);
    //     }else{
    //         root.left=insertNode(root.left,x);
    //     }
    //     return root;
    // }

    //TC : O(n) - O(h)
    static Node post_order(int pre[]){
        i=0;
        return solve(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static Node solve(int[] arr,int min,int max){
        if(i>arr.length-1) return null;
        else if(arr[i]<min || arr[i]>max) return null;
        Node root=new Node(arr[i++]); 
        root.left=solve(arr,min,root.data);
        root.right=solve(arr,root.data,max);
        return root;
    }
}
