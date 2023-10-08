package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

import LinkedList.utils.Node;

public class SegregateLinkedList {
    public static void main(String[] args) {
        Node head=new Node(2);
        Node n1=new Node(0);
        Node n2=new Node(1);
        Node n3=new Node(2);
        Node n4=new Node(1);
        Node n5=new Node(1);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node.printList(head);

        head=segragateLL(head);
        Node.printList(head);
    }

    //TC : O(n)
    static Node segragateLL(Node head){
        ArrayList<Node> arr=new ArrayList<>();
        Node curr=head;
        while(curr!=null){
            arr.add(curr);
            curr=curr.next;
        }
        Collections.sort(arr,(n1,n2)->(n1.data-n2.data));

        Node dhead=arr.get(0);
        Node newHead=dhead;
        for(int i=1;i<arr.size();i++){
            newHead.next=new Node(arr.get(i).data);
            newHead=newHead.next;
        }
        return dhead;
    }
}
