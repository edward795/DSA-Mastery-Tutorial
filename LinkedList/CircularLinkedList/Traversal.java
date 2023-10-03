package LinkedList.CircularLinkedList;

public class Traversal {
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
        n4.next=head;
        Node.printList(head);
    }

}
