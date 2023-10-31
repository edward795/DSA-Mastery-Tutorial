package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        levelOrder(root);
    }

    //TC : O(n) - O(n) or O(w) where 0<=O(w)<=n & w is the width of the binary tree
    static void levelOrder(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
}
