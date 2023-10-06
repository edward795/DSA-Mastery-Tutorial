package LinkedList;

import java.util.HashSet;

public class DetectCycleInLL {
    public static void main(String[] args) {
        ModNode head=new ModNode(10);
        ModNode n1=new ModNode(20);
        ModNode n2=new ModNode(30);
        ModNode n3=new ModNode(40);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n1;

        System.out.println("is cycle loop present in Linked List:"+detectCycle(head));
    }

    //Naive Soln TC : O(n^2)
    // static boolean detectCycle(Node head){
    //     Node curr=head;
    //     while(curr!=null){
    //          Node temp=curr.next;
    //         while(temp!=null){
    //             if(curr==temp) return true;
    //             temp=temp.next;
    //         }
    //         curr=curr.next;
    //     }
    //     return false;
    // }

    //Efficient Soln  : O(n) - O(n)
    // static boolean detectCycle(Node head){
    //     HashSet<Node> h=new HashSet<>();
    //     Node curr=head;
    //     while(curr!=null){
    //         if(h.contains(curr)) return true;
    //         h.add(curr);
    //         curr=curr.next;
    //     }
    //     return false;
    // }

    ///Efificent Soln :O(n) - O(1) - by modifying a node of the linked list to include new parameter visited.
    // static boolean detectCycle(ModNode head){
    //     ModNode curr=head;
    //     while(curr!=null){
    //         curr=curr.next;
    //         if(curr.visited==1) return true;
    //         curr.visited=1;
    //     }
    //     return false;
    // }
    
    //Efficent Soln : O(n) - O(1) - by modifying the next pointer of a node
    // static boolean detectCycle(ModNode head){
    //     ModNode curr=head,temp=new ModNode(-1);
    //     while(curr!=null){
    //         if(curr.next==null) return false;
    //         if(curr.next==temp) return true;
    //         ModNode next=curr.next;
    //         curr.next=temp;
    //         curr=next;
    //     }
    //     return false;
    // }

    //Most Efficient Soln :O(n) - O(1)
    static boolean detectCycle(ModNode head){
        ModNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) return true;
        }
        return false;
    }
}


class ModNode{
    int data;
    int visited;
    ModNode next;

    ModNode(int data){
        this.data=data;
    }
}
