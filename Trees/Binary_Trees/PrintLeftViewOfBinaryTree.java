package Trees.Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftViewOfBinaryTree {

    static int maxLevel=0;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        // printLeftView(root, 1);
        printLeftView(root);

    }

    //Method 1 - Recursive - O(n) - O(h)
    // static void printLeftView(Node root,int level){
    //     if(root==null) return;
    //     if(maxLevel<level){
    //         System.out.print(root.data+" ");
    //         maxLevel=level;
    //     }

    //     printLeftView(root.left, level+1);
    //     printLeftView(root.right, level+1);
    // }

    //Method 2 - iterative - O(n) - O(h)
    static void printLeftView(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                if(i==0) 
                    System.out.print(curr.data+" ");

                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
}
