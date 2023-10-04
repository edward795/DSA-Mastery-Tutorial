package LinkedList;
import java.util.ArrayList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class ReverseALinkedList {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        head=reverseLL(head,null);
        Node.printList(head);
    }

    //Naive Soln : O(n)
    // static Node reverseLL(Node head){
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     Node curr=head;
    //     while(curr!=null){
    //         arr.add(curr.data);
    //         curr=curr.next;
    //     }

    //     curr=head;
    //     for(int i=0;i<arr.size()&&curr!=null;i++){
    //         curr.data=arr.remove(arr.size()-1);
    //         curr=curr.next;
    //     }

    //     return head;
    // }

    //Efficient Soln : iterative
    // static Node reverseLL(Node head){
    //     Node prev=null,curr=head;
    //     while(curr!=null){
    //         Node next=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=next;
    //     }
    //     return prev;
    // }

    ///Efficient Soln :O(n) -O(n) recursive  method 1
    // static Node reverseLL(Node head){
    //     if(head==null || head.next==null) return head;
    //     Node rest_head=reverseLL(head.next);
    //     Node rest_tail=head.next;
    //     rest_tail.next=head;
    //     head.next=null;
    //     return rest_head;
    // }
    
    //Efficent Soln :O(n) - O(n) - recursive method 2
    static Node reverseLL(Node curr,Node prev){
        if(curr==null) return prev;
        Node next=curr.next;
        curr.next=prev;
        return reverseLL(next, curr);
    }
}
