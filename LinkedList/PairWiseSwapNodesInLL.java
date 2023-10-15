package LinkedList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class PairWiseSwapNodesInLL {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        head=swapPairWise(head);
        Node.printList(head);
    }

    //Naive Soln : O(n) - O(1)
    // static Node swapPairWise(Node head){
    //     Node curr=head;
    //     while(curr.next!=null && curr.next.next!=null){
    //         int temp=curr.data;
    //         curr.data=curr.next.data;
    //         curr.next.data=temp;
    //         curr=curr.next.next;
    //     }
    //     return head;
    // }

    //Efficient Soln : O(n) - O(1))
    // static Node swapPairWise(Node head){
    //     if(head==null || head.next==null) return head;

    //     Node curr=head.next.next;
    //     Node prev=head;
    //     head=head.next;
    //     head.next=prev;

    //     while(curr!=null && curr.next!=null){
    //         prev.next=curr.next;
    //         prev=curr;
    //         Node next=curr.next.next;
    //         curr.next.next=curr;
    //         curr=next;
    //     }
    //     prev.next=curr;
    //     return head;
    // }

    static Node swapPairWise(Node head){
        if(head==null || head.next==null) return head;

        Node temp=new Node(0);
        temp.next=head;

        Node curr=temp;
        while(curr.next!=null && curr.next.next!=null){
            Node fnode=curr.next;
            Node snode=curr.next.next;
            fnode.next=snode.next;
            curr.next=snode;
            curr.next.next=fnode;
            curr=curr.next.next;
        }
        return temp.next;
    }
}
