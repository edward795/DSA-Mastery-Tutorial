package Trees.Binary_Trees;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        BTNode root=new BTNode(10);
        root.left=new BTNode(20);
        root.right=new BTNode(30);
        root.left.left=new BTNode(40);
        root.right.right=new BTNode(50);
    }
}


class BTNode{
    int data;
    BTNode  left,right;


    BTNode(int d){
        data=d;
        left=null;
        right=null;
    }
}
