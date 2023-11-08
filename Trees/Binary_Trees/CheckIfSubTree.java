package Trees.Binary_Trees;

public class CheckIfSubTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();

        Node root2=new Node(20);
        root2.left=new Node(40);
        root2.right=new Node(50);

        System.out.println("Is one tree a subtree ? "+isSubTree(root, root2));

    }

    //TC : O(n) -O(h)
    // static String inorder(Node root){
    //     if(root==null) return "#";
    //     return ("("+String.valueOf(root.data)+inorder(root.left)+inorder(root.right)+")");
    // }

    // static boolean isSubTree(Node T,Node S){
    //     String s1=inorder(T);
    //     String s2=inorder(S);  
    //     return s1.contains(s2);  
    // }



    static boolean isSame(Node T,Node S){
        if(T==null && S==null) return true;
        if(T==null || S==null) return false;

        if(T.data!=S.data) return false;

        return isSame(T.left, S.left) && isSame(T.right,S.right);
    }

    //TC : O(n) - O(h)
    static boolean isSubTree(Node T,Node S){
        if(T==null && S==null) return true;
        if(T==null || S==null) return false;

        return isSame(T,S) || isSubTree(T.left, S) || isSubTree(T.right, S);
    }
}
