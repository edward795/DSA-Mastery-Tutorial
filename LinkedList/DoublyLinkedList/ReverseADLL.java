package LinkedList.DoublyLinkedList;

public class ReverseADLL {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);

        head.next=n1;
        n1.prev=head;
        n1.next=n2;
        n2.prev=n1;
        n2.next=n3;
        n3.prev=n2;

        Node.printForward(head);
        head=reverseDLL(head);
        System.out.println();

        Node.printForward(head);
    }

    // TC : O(n)
    // static Node reverseDLL(Node head){
    //     if(head==null || head.next==null) return head;
    //     Node prev=null;
    //     Node curr=head;
    //     while(curr!=null){
    //         Node next=curr.next;
    //         curr.prev=curr.next;        
    //         curr.next=prev;
    //         prev=curr;
    //         curr=next;
    //     }
    //     return prev;
    // }

    //Note you can save space by not using next pointer & updating curr=curr.prev & prev= prev.prev
    static Node reverseDLL(Node head){
        if(head==null || head.next==null) return head;
        Node curr=head,prev=null;
        while(curr!=null){
            prev=curr.prev;
            curr.prev=curr.next;
            curr.next=prev;
            curr=curr.prev;
        }
        return prev.prev;
    }
}
