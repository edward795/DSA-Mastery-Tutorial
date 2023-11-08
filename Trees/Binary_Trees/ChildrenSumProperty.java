package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Does this tree follow child sum property ? "+isSum(root));
    }

    //TC : O(n) - O(h) - recursive
    // static boolean isSum(Node root){
    //     if(root==null) return true;
    //     if(root.left!=null && root.right!=null) return true;

    //     int sum=0;
    //     if(root.left!=null) sum+=root.left.data;
    //     if(root.right!=null) sum+=root.right.data;

    //     return (root.data==sum && isSum(root.left) && isSum(root.right));
    // }

    //TC : O(n) - O(h) - iterative
    static boolean isSum(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);

            if(curr.left!=null && curr.right!=null){
                if(curr.data!=curr.left.data+curr.right.data) return false;
            }

            if(curr.left!=null && curr.right==null){
                if(curr.data!=curr.left.data) return false;
            }

            if(curr.right!=null && curr.left==null){
                if(curr.data!=curr.right.data) return false;
            }
        }
        return true;
    }
}
