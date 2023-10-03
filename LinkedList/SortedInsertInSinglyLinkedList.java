package LinkedList;
import LinkedList.utils.Node;

public class SortedInsertInSinglyLinkedList {
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
        head=sortedInsert(head, 45);
        Node.printList(head);
    }

    //TC : O(pos)
    static Node sortedInsert(Node head,int x){
        Node temp=new Node(x);
        if(head==null) return temp;
        if(head.data>x){
            temp.next=head;
            return temp;
        }
        Node curr=head;
        while(curr.next!=null && curr.next.data<x){
            curr=curr.next;
        }
        temp.next=curr.next;
        curr.next=temp;
        return head;
    }
}
