package LinkedList.CircularLinkedList;

public class Node {
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }

    static void printList(Node head){
        Node curr=head;
        while(curr.next!=head){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
    }
}
