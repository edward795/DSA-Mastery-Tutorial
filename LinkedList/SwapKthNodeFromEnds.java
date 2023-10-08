package LinkedList;


import LinkedList.utils.Node;
import LinkedList.utils.LinkedList;

public class SwapKthNodeFromEnds {
    public static void main(String[] args) {
        Node head=LinkedList.getLinkedList();
        Node.printList(head);

        head=swapKthNode(head, 5, 2);
        Node.printList(head);
    }

    //TC : O(k) - O(1)
    static Node swapKthNode(Node head,int num,int k){
        if(k>num) return head;
        if(k==num-k+1) return head;
        Node first=head,second=head;
        Node p1=null,p2=null;

        int end=num-k+1;
        for(int i=1;i<k;i++){
            p1=first;
            first=first.next;
        }

        for(int i=1;i<end;i++){
            p2=second;
            second=second.next;
        }

        if(p1!=null){
            p1.next=second;
        }
        if(p2!=null){
            p2.next=first;
        }

        Node temp=first.next;
        first.next=second.next;
        second.next=temp;

        if(k==1) return second;
        if(k==num) return first;
        return head;
    }
}
