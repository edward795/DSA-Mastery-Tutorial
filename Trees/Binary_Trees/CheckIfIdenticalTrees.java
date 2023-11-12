package Trees.Binary_Trees;

public class CheckIfIdenticalTrees {
    public static void main(String[] args) {
        Node root1=Node.getTreeRoot();
        Node root2=Node.getTreeRoot();
        System.out.println("Are the 2 trees equal ? "+areIdentical(root1, root2));
    }

    static boolean areIdentical(Node root1,Node root2){
        if(root1==null && root2==null) return true;
        if((root1==null && root2!=null) || (root2!=null && root1==null)) return false; //or (root1==null || root2==null)
        return root1.data==root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }
}
