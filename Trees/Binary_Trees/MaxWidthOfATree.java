package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfATree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Max Width of A BTree is " +maxWidth(root));
    }

    //TC : O(n) - O(h)
    static int maxWidth(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int res=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                res=Math.max(res,count);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            } 
        }
        return res;
    }
}
