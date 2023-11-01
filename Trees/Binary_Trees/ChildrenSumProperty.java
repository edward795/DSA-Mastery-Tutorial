package Trees.Binary_Trees;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Does this tree follow child sum property ? "+isSum(root));
    }

    //TC : O(n) - O(h)
    static boolean isSum(Node root){
        if(root==null) return true;
        if(root.left!=null && root.right!=null) return true;

        int sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;

        return (root.data==sum && isSum(root.left) && isSum(root.right));
    }
}
