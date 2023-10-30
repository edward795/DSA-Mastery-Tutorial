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
        return root;
    }
}




