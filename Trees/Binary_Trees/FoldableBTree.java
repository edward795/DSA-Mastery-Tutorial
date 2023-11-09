package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class FoldableBTree {
    public static void main(String[] args) {
        Node root = Node.getTreeRoot();
        System.out.println("The Tree is Foldable or not ? " + isFoldable(root));
    }

    // static boolean isFoldableUtil(Node n1,Node n2){
    // if(n1==null && n2==null) return true;
    // if(n1==null || n2==null) return false;

    // return isFoldableUtil(n1.left, n2.right) && isFoldableUtil(n1.right,
    // n2.left);
    // }

    // //TC : O(n) - O(h) - recursive
    // static boolean isFoldable(Node root){
    // if(root==null) return true;
    // return isFoldableUtil(root.left, root.right);
    // }

    // TC : iterative Soln : O(n) - O(h)
    static boolean isFoldable(Node root) {
        if (root == null)
            return true;
        Queue<Node> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            Node p1 = q.poll();
            Node p2 = q.poll();
            if (p1 == null && p2 == null)
                return true;
            if ((p1 == null && p2 != null) || (p2 == null && p1 != null)) {
                return false;
            }
            q.add(p1.left);
            q.add(p2.right);
            q.add(p1.right);
            q.add(p2.left);
        }
        return true;
    }
}
