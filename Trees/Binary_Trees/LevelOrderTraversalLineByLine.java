package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLine {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        levelOrderLineByLine(root);
    }

    //Method 1 : TC :O(n) - O(n)
    // static void levelOrderLineByLine(Node root){
    //     Queue<Node> q=new LinkedList<>();
    //     q.add(root);
    //     q.add(null);
    //     while(q.size()>1){
    //         Node curr=q.poll();
    //         if(curr==null){
    //             System.out.println();
    //             q.add(null);
    //             continue;
    //         }
    //         System.out.print(curr.data+" ");
    //         if(curr.left!=null) q.add(curr.left);
    //         if(curr.right!=null) q.add(curr.right);
    //     }
    // }

    //TC : O(n) - O(n)
    static void levelOrderLineByLine(Node root){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                System.out.print(curr.data+" ");
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            System.out.println();
        }
    }
}
