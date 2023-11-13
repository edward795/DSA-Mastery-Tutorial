package Trees.Binary_Search_Tree;

public class Node {
    int data;
    Node left,right;

    Node(int d){
        data=d;
        left=null;
        right=null;
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static Node getBST(){
        int[] arr=new int[]{20,15,30,40,50,12,18,35,80,7};
        Node root=null;
        for(Integer i:arr)
            root=insert(root, i);
        return root;    
    }

     static Node insert(Node root,int x){
        Node temp=new Node(x);
        if(root==null) return temp;
        if(root.data<x){
            root.right=insert(root.right,x);
        }else if(root.data>x){
            root.left=insert(root.left,x);
        }
        return root;
    }
}
