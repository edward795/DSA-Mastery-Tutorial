package LinkedList.utils;
import LinkedList.utils.Node;

public class LinkedList {
    public static Node head=null;

    public static Node getLinkedList(){
        head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return head;
    }
}
