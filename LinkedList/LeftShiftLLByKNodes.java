package LinkedList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class LeftShiftLLByKNodes {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);
        head=shiftByK(head, 3);
        Node.printList(head);
    }

    //TC: O(n)
    static Node shiftByK(Node head,int k){
        Node a=head;
        for(int i=0;i<k-1;i++) 
            a=a.next;

        Node b=head;
        while(b.next!=null){
            b=b.next;
        }

        b.next=head;
        head=a.next;
        a.next=null;
        return head;
    }
}
