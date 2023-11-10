package Trees.Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class constructBTreeFromLL {
    public static void main(String[] args) {
        LNode head=new LNode(10);
        head.next=new LNode(20);
        head.next.next=new LNode(30);
        head.next.next.next=new LNode(40);
        head.next.next.next.next=new LNode(50);

        Node root=convert(head);
        Node.printTree(root);
    }

    //TC : O(n) - O(h)  - recursive
    // static Node constructTree(ArrayList<Integer> arr,int i){
    //     if(i>=arr.size()) return null;
    //     Node root=new Node(arr.get(i));
    //     root.left=constructTree(arr, 2*i+1);
    //     root.right=constructTree(arr, 2*i+2);
    //     return root;
    // }

    // static Node convert(LNode head){
    //     if(head==null) return null;
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     LNode curr=head;
    //     while(curr!=null){
    //         arr.add(curr.data);
    //         curr=curr.next;
    //     }
    //     return constructTree(arr, 0);
    // }

    //TC : O(n) - O(h)
    static Node convert(LNode head){
        if(head==null) return null;
        Queue<Node> q=new LinkedList<>();
        Node root=new Node(head.data);
        q.add(root);
        while(head!=null){
            Node curr=q.poll();
            head=head.next;
            if(head!=null){
                curr.left=new Node(head.data);
                q.add(curr.left);
                head=head.next;
            }

            if(head!=null){
                curr.right=new Node(head.data);
                q.add(curr.right);
            }
        }
        return root;
    }
}

class LNode{
    int data;
    LNode next;

    LNode(int d){
        data=d;
        next=null;
    }
}
