package LinkedList.DoublyLinkedList;

public class Node {
    int data;
    Node prev,next;

    Node(int data){
        this.data=data;
        prev=null;
        next=null;
    }

    static void printForward(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print("null");
    }
}
