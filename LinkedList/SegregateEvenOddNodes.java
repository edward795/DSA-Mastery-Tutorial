package LinkedList;

import LinkedList.utils.Node;

public class SegregateEvenOddNodes {
    public static void main(String[] args) {
        Node head=new Node(17);
        Node n1=new Node(15);
        Node n2=new Node(8);
        Node n3=new Node(12);
        Node n4=new Node(5);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        Node.printList(head);

        head=segregateEvenOdd(head);
        Node.printList(head);
    }

    // static Node segregateEvenOdd(Node head){
    //     Node curr=head;
    //     while(curr.next!=null){
    //         curr=curr.next;
    //     }
    //     if(head.data%2!=0){
    //         Node next=head.next;
    //         curr.next=head;
    //         curr=head;
    //         head=next;
    //         return head;
    //     }
    //     Node temp=head;
    //     while(temp!=null){
    //         if(temp.data%2==1){
    //             Node next=temp.next;
    //             curr.next=temp;
    //             curr=temp;
    //             temp=curr;
    //         }else{
    //             temp=temp.next;
    //         }
    //     }

    //     return head;
    // }
    
    //Efficient Soln : O(n) - O(1) - 4 pointer approach
    static Node segregateEvenOdd(Node head){
        Node es=null,ee=null,os=null,oe=null;
        Node curr=head;
        while(curr!=null){
            if(curr.data%2==0){
                if(es==null){
                    es=ee=curr;
                }else{
                    ee.next=curr;
                    ee=ee.next;
                }
            }else{
                if(os==null){
                    os=oe=curr;
                }else{
                    oe.next=curr;
                    oe=oe.next;
                }
            }
            curr=curr.next;
        }

        if(os==null || oe==null) return head;
        ee.next=os;
        oe.next=null;
        return es;
    }
}
