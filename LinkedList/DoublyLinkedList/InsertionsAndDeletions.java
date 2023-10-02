package LinkedList.DoublyLinkedList;

public class InsertionsAndDeletions {
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

        Node.printForward(head);
        System.out.println();
        head=insertBegin(head, 50);
        Node.printForward(head);

        System.out.println();
        head=deleteHead(head);
        Node.printForward(head);

        System.out.println();
        head=deleteLast(head);
        Node.printForward(head);

        System.out.println();
        head=insertLast(head, 100);
        Node.printForward(head);
    }

    //TC : O(1)
    static Node insertBegin(Node head,int x){
        Node temp=new Node(x);
        temp.next=head;
        if(head!=null) 
            head.prev=temp;
        return temp;
    }

    //TC : O(n)
    static Node insertLast(Node head,int x){
        Node temp=new Node(x);
        if(head==null) return temp;

        Node curr=head;
        while(curr.next!=null) 
            curr=curr.next;
        curr.next=temp;
        temp.prev=curr;
        return head;
    }

    //TC : O(1)
    static Node deleteHead(Node head){
        if(head==null) return null;
        if(head.next==null) return null;
        else{
            head=head.next;
            head.prev=null;
            return head;
        }
    }

    //TC : O(n)
    static Node deleteLast(Node head){
        if(head==null) return null;
        if(head.next==null) return null;
        Node curr=head;
        while(curr.next!=null) 
            curr=curr.next;
        curr.prev.next=null;
        return head;
    }
}
