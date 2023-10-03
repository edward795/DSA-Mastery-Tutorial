package LinkedList.CircularLinkedList;

public class Deletions {
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
        n6.next=head;
        Node.printList(head);
        System.out.println();

        head=deleteHead(head);
        Node.printList(head);

        System.out.println();
        head=deleteHeadEfficient(head);
        Node.printList(head);

        System.out.println();
        head=deleteKthNode(head, 3);
        Node.printList(head);
    }

    //TC : O(n)
    static Node deleteHead(Node head){
        if(head==null) return null;
        if(head.next==null) return null;

        Node curr=head;
        while(curr.next!=head) 
            curr=curr.next;
        curr.next=head.next;
        return curr.next;
    }

    //TC : O(1)
    static Node deleteHeadEfficient(Node head){
        if(head==null) return null;
        if(head.next==null) return null;
        head.data=head.next.data;
        head.next=head.next.next;
        return head;
    }


    //TC : O(1)
    static Node deleteKthNode(Node head,int k){
        if(k==1){
            head.data=head.next.data;
            head.next=head.next.next;
            return head;
        }

        Node curr=head;
        for(int i=1;i<=k-2 && curr.next!=head;i++)
            curr=curr.next;

        curr.next=curr.next.next;
        return head;
    }
}
