package Trees.Binary_Trees;

public class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int c){
        data=c;
        left=null;
        right=null;
    }

    public static Node getTreeRoot(){
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);
        return root;
    }


    public static void printTree(Node root){
        if(root!=null){
            printTree(root.left);
            System.out.print(root.data+" ");
            printTree(root.right);
        }
    }
}




