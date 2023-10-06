package LinkedList;

import LinkedList.utils.Node;

public class DeleteANodeWithOnlyPointer {
    public static void main(String[] args) {
        Node head=new Node(1);
        Node n1=new Node(12);
        Node n2=new Node(1);
        Node n3=new Node(4);
        Node n4=new Node(1);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        Node.printList(head);
        deleteNodeWithOnlyPointer(head); //here we gave head to delete
        Node.printList(head);

        deleteNodeWithOnlyPointer(n3); //delete 3rd node given as pointer
        Node.printList(head);
    }

    static void deleteNodeWithOnlyPointer(Node node){

        if(node==null || node.next==null) return;

        node.data=node.next.data;
        node.next=node.next.next;
    }
}
