package LinkedList.DoublyLinkedList;

public class DoublyLinkedListTraversal {
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

        printForward(head);
        printBackward(head);
    }

    static void printForward(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.print("null");
    }

    static void printBackward(Node head){
        Node curr=head;
        while(curr.next!=null) 
            curr=curr.next;
        
        System.out.println();
        System.out.print("null<-");
        while(curr!=null){ 
            System.out.print(curr.data+"<-");
            curr=curr.prev;
        }
    }
}
