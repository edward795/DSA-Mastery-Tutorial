package LinkedList;
import LinkedList.utils.LinkedList;
import LinkedList.utils.Node;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        nthNodeFromEnd(head, 3);
    }

    //Naive Soln : O(n)
    // static void nthNodeFromEnd(Node head,int k){
    //     Node curr=head;
    //     int count=0;
    //     while(curr!=null){
    //         curr=curr.next;
    //         count++;
    //     }

    //     if(k>count) return;

    //     curr=head;
    //     for(int i=1;i<count-k+1;i++) 
    //         curr=curr.next;

    //     System.out.println(curr.data);
    // }

    //Efficient Soln :O(n) using 2 pointers
    static void nthNodeFromEnd(Node head,int k){
        Node first=head;
        for(int i=0;i<k;i++){
            if(first==null) return;
            first=first.next;
        }

        Node second=head;
        while(first!=null){
            second=second.next;
            first=first.next;
        }

        System.out.println(second.data);
    }
}
