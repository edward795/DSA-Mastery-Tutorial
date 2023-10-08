package LinkedList;

import java.util.HashSet;

import LinkedList.utils.Node;

public class RemoveDuplicatesFromUnSortedLL {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(12);
        Node n2=new Node(14);
        Node n3=new Node(10);
        Node n4=new Node(10);


        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;

        Node.printList(head);
        removeDups(head);
        Node.printList(head);
    }

    //Efficient SOln : O(n)
    static void removeDups(Node head){
        HashSet<Integer> hm=new HashSet<>();
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            if(hm.contains(curr.data)){
                prev.next=curr.next;
            }else{
                hm.add(curr.data);
                prev=curr;
            }
            curr=curr.next;
        }
    }
}
