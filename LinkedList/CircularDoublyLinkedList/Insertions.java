package LinkedList.CircularDoublyLinkedList;

public class Insertions {
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
        n3.next=head;

        Node.printList(head);

        System.out.println();
        head=insertHead(head, 100);
        Node.printList(head);

        System.out.println();
        head=insertEfficient(head, 110);
        Node.printList(head);
    }

    //TC : O(n)
    static Node insertHead(Node head,int x){
        Node temp=new Node(x);
        if(head==null){
            temp.next=temp;
            temp.prev=temp;
            return temp;
        }

        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        temp.next=head;
        head.prev=temp;
        return temp;
    }

    //TC : O(1)
    static Node insertEfficient(Node head,int x){
        Node temp=new Node(x);
        if(head==null){
            temp.next=temp;
            temp.prev=temp;
            return temp;
        }

        temp.prev=head.prev;
        head.prev.next=temp;
        temp.next=head;
        head.prev=temp;
        return temp;
    }
}
