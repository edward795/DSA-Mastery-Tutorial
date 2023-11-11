package Trees.Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right.left=new Node(60);
        root.right.right=new Node(70);

        connectSameLevel(root);

    }

    //TC : O(n) - O(h)
    static void connectSameLevel(Node root){
        Queue<Node> q=new LinkedList<>();
        ArrayList<Node> al=new ArrayList<>();

        q.add(root);
        q.add(null);
        al.add(root);
        al.add(null);

        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr==null && q.size()>0){
                q.add(null);
                al.add(null);
            }else if(curr!=null){
                if(curr.left!=null){
                    q.add(curr.left);
                    al.add(curr.left);
                }

                if(curr.right!=null){
                    q.add(curr.right);
                    al.add(curr.right);
                }
            }

            for(int i=0;i<al.size();i++){
                if(al.get(i)!=null && al.get(i+1)!=null){
                    al.get(i).nextRight=al.get(i+1);
                }
            }
        }
    }
}

class Node{
    int data;
    Node left,right,nextRight;

    Node(int d){
        data=d;
        left=null;
        right=null;
        nextRight=null;
    }

    public static Node getTreeRoot() {
        return null;
    }
}
