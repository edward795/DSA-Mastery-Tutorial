package LinkedList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class FindIntersectionPointOfLL {
    public static void main(String[] args) {
        Node head1=LinkedList.getLinkedList();
        Node.printList(head1);
        Node head2=new Node(35);
        Node n1=new Node(37);
        head2.next=n1;
        n1.next=head1.next.next;

        System.out.println("Intersection Point is:"+intersectionPoint(head1, head2));
    }

    //TC : O(n)
    // static int intersectionPoint(Node head1,Node head2){
    //     Node headA=head1;
    //     Node headB=head2;

    //     while(headA!=headB){
    //         if(headA!=null) headA=headA.next;
    //         else headA=head2;

    //         if(headB!=null) headB=headB.next;
    //         else headB=head1;
    //     }
    //     return headA!=null?headA.data:-1;
    // }

    //TC : O(n)
    static int intersectionPoint(Node head1,Node head2){
        Node a=head1;
        Node b=head2;

        if(a==null || b==null) return 0;
        while(a!=b){
            a=a==null?head2:a.next;
            b=b==null?head1:b.next;
        }
        return a.data;
    }
}
