package LinkedList.CircularLinkedList;

public class Insertions {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=head;
        Node.printList(head);
        System.out.println();

        head=insertBegin(head,70);
        Node.printList(head);

        System.out.println();
        head=insertBeginEfficient(head, 100);
        Node.printList(head);
    }

    //TC : O(n)
    static Node insertBegin(Node head,int x){
        Node temp=new Node(x);
        if(head==null){
            temp.next=temp;
            return temp;
        }

        Node curr=head;
        while(curr.next!=head){
            curr=curr.next;
        }
        curr.next=temp;
        temp.next=head;
        return temp;
    }
    //TC : O(1)
    static Node insertBeginEfficient(Node head,int x){
        Node temp=new Node(x);
        if(head==null){
            temp.next=temp;
            return temp;
        }else{
            temp.next=head.next;
            head.next=temp;
            int data=temp.data;
            temp.data=head.data;
            head.data=data;
            return head;
        }
    }
}
