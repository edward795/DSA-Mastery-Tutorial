package LinkedList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class ReverseInKGroups {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        reverseInGroups(head, 3);
        Node.printList(head);
    }

    //Naive Soln : O(n)
    // static Node reverseInGroups(Node head,int k){
    //     Node prev=null,next=null,curr=head;
    //     int count=0;
    //     while(curr!=null && count<k){
    //         next=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=next;
    //         count++;
    //     }

    //     if(next!=null){
    //         Node rest_head=reverseInGroups(next, k);
    //         head.next=rest_head;
    //     }
    //     return prev;
    // }


    //Efficient Soln : O(n)
    static Node reverseInGroups(Node head,int k){
        Node curr=head,prevFirst=null;
        boolean isFirstPass=true;
        while(curr!=null){
            Node first=curr,prev=null;
            int count=0;

            while(curr!=null && count<k){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            if(isFirstPass){
                head=prev;
                isFirstPass=false;
            }else{
                prevFirst=first;
                prevFirst.next=prev;
            }
        }
        return head;
    }
}
