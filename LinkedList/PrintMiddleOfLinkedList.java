package LinkedList;

import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class PrintMiddleOfLinkedList{
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        printMiddle(head);
        
    }

    // //Naive Soln : O(n)
    // static void printMiddle(Node head){
    //     if(head==null){
    //         System.out.println(-1);
    //         return;
    //     }
    //     Node curr=head;
    //     int count=1;
    //     while(curr!=null){
    //         curr=curr.next;
    //         count++;
    //     }

    //     curr=head;
    //     for(int i=1;i<count/2;i++) 
    //         curr=curr.next;

    //     System.out.println(curr.data);
    // }

    //Efficient Soln : using 2 pointers
    // static void printMiddle(Node head){
    //     Node slow=head,fast=head;
    //     while(fast.next!=null && fast.next.next!=null){
    //         slow=slow.next;
    //         fast=fast.next.next;
    //     }

    //     System.out.println(slow.data);
    // }

    //Efficient Soln : O(n)
    static void printMiddle(Node head){
        Node mid=head;
        int count=0;
        while(head!=null){
            if(count%2==1) 
                mid=mid.next;
            count++;
            head=head.next;
        }
        System.out.println(mid.data);
    }
}