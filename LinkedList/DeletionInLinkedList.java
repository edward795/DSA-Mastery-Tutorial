package LinkedList;
import LinkedList.utils.Node;

public class DeletionInLinkedList {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);
        Node n5=new Node(60);
        Node n6=new Node(70);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        Node.printList(head);
        head=deleteFront(head);

        Node.printList(head);

        head=deleteLast(head);
        Node.printList(head);
    }

    //TC : O(1)
    static Node deleteFront(Node head){
        if(head==null) return null;
        return head.next;
    }

    //TC : O(n)
    static Node deleteLast(Node head){
        if(head==null) return null;

        Node curr=head; 
        while(curr.next.next!=null) 
            curr=curr.next;
        
        curr.next=null;
        return head;
    }
}
