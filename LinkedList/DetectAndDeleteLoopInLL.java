package LinkedList;

import LinkedList.utils.Node;

public class DetectAndDeleteLoopInLL {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;

        detectAndDeleteCycle(head); // Note if the cycle was not removed it would result in infinite loop
        Node.printList(head);
    }

    //TC : O(n) - O(1)
    static void detectAndDeleteCycle(Node head){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast) break;
        }
        if(slow!=fast) return;
        slow=head;

        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }

        fast.next=null;
    }
}

