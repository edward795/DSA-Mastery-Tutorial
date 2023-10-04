package LinkedList;

import LinkedList.utils.Node;

public class RemoveDuplicatesFromSortedLL {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(20);
        Node n3=new Node(30);
        Node n4=new Node(30);
        Node n5=new Node(30);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node.printList(head);

        removeDups(head);
        Node.printList(head);
        
    }

    //TC : O(n)
    static Node removeDups(Node head){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(curr.data==curr.next.data){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
}
