package Trees.Binary_Search_Tree;

public class LevelOrderToBST {
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        Node root=constructBST(arr);
        Node.inorder(root);
    }

    //TC : O(n) - O(n)
    public static Node constructBST(int[] arr){
        Node root=new Node(arr[0]);
        for(int i=1;i<arr.length;i++){
            insertNode(root, i);
        }
        return root;
    }

    static Node insertNode(Node root,int x){
        Node temp=new Node(x);
        if(root==null) return temp;
        if(root.data>x) 
            root.left=insertNode(root.left, x);
        else    
            root.right=insertNode(root.left,x); 
        return root;
    }
}
