package Trees.Binary_Search_Tree;

public class Search {
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println("Is the element present in BST ? "+search(root,35));
    }

    //TC  : O(h) - O(1) - iterative
    // static boolean search(Node root,int x){
    //     while(root!=null){
    //         if(root.data==x)
    //             return true;
    //         else if(root.data>x) 
    //             root=root.left;
    //         else 
    //             root=root.right;
    //     }
    //     return false;
    // }

    //TC : O(h) - O(h) - recursive
    static boolean search(Node root,int x){
        if(root==null) return false;
        if(root.data==x) 
            return true;
        else if(root.data>x) 
            return search(root.left,x);
        else 
            return search(root.right,x);
    }
}
