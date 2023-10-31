package Trees.Binary_Trees;

public class PrintNodesAtKDistance {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        printNodesAtK(root, 2);
    }

    //TC : O(n) - O(h)
    static void printNodesAtK(Node root,int k){
        if(root==null) return;
        if(k==0) System.out.print(root.data+" ");
        else{
            printNodesAtK(root.left, k-1);
            printNodesAtK(root.right, k-1);
        }
    }
}
