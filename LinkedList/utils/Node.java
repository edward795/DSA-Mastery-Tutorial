package LinkedList.utils;

public class Node {
    int data;
    public Node next;

    public Node(int data){
        this.data=data;
        next=null;
    }

    public static void printList(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print("null");
    }
}
