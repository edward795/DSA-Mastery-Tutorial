package LinkedList;

import LinkedList.utils.Node;

public class InsertionsInLinkedLIist {
    public static void main(String[] args) {
        Node head=null;
        head=insertBegin(head, 10);
        head=insertBegin(head, 20);
        head=insertBegin(head, 30);
        head=insertBegin(head, 40);
        head=insertEnd(head, 50);
        head=insertEnd(head, 60);
        Node.printList(head);

        insertAtPos(head, 3, 70);
        Node.printList(head);
    }

    //TC : O(1)
    static Node insertBegin(Node head,int x){
        Node temp=new Node(x);
        if(head==null) return temp;

        temp.next=head;
        return temp;
    }

    //TC : O(n)
    static Node insertEnd(Node head,int x){
        Node temp=new Node(x);
        if(head==null) return temp;

        Node curr=head;
        while(curr.next!=null)
            curr=curr.next;

        curr.next=temp;
        return head;
    }

    //TC :O(n)
    static Node insertAtPos(Node head,int pos,int x){
        Node temp=new Node(x);
        if(pos==1){
            temp.next=head;
            return temp.next;
        }

        Node curr=head;
        for(int i=1;i<=pos-2 && curr!=null;i++) 
            curr=curr.next;
        if(curr==null) 
            return head;
        temp.next=curr.next;
        curr.next=temp;
        return head;
    }
}
