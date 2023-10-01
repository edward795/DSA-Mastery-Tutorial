package LinkedList;

public class TraversalOfLinkedList {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;

        printList(head);
    }

    //TC : O(n) - O(1)
    // static void printList(Node head){
    //     Node curr=head;
    //     while(curr!=null){
    //         System.out.print(curr.data+"->");
    //         curr=curr.next;
    //     }
    //     System.out.print("null");
    // }

    //TC : O(n) - O(n) - recursive approach
    static void printList(Node head){
        if(head==null){
            System.out.print("null");
            return;
        }

        System.out.print(head.data+"->");
        printList(head.next);
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }
}
