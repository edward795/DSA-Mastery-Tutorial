package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

import LinkedList.utils.Node;

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        Node head1=new Node(10);
        Node n1=new Node(15);
        Node n2=new Node(25);
        Node n3=new Node(35);

        head1.next=n1;
        n1.next=n2;
        n2.next=n3;

        Node.printList(head1);

        Node head2=new Node(11);
        Node n4=new Node(17);
        Node n5=new Node(27);

        head2.next=n4;
        n4.next=n5;

        Node.printList(head2);

        Node.printList(mergeList(head1, head2));
    }

    //Naive Soln : O(nlogn) - O(1)
    // static Node mergeList(Node head1,Node head2){
    //     ArrayList<Node> arr=new ArrayList<>();
    //     Node curr=head1;
    //     while(curr!=null){
    //         arr.add(curr);
    //         curr=curr.next;
    //     }

    //     curr=head2;
    //     while(curr!=null){
    //         arr.add(curr);
    //         curr=curr.next;
    //     }
        
    //     Collections.sort(arr,(n1,n2)->n1.data-n2.data);

    //     for(int i=0;i<arr.size()-1;i++){
    //         curr=arr.get(i);
    //         curr.next=arr.get(i+1);
    //     }
    //     return arr.get(0);
    // }

    //Efficient Soln : O(n) - O(1)
    static Node mergeList(Node a,Node b){
        if(a==null) return b;
        if(b==null) return a;

        Node head=null,tail=null;
        if(a.data<=b.data){
        head=tail=a;
        a=a.next;
        }else{
        head=tail=b;
        b=b.next;
        }
        
        while(a!=null && b!=null){
        if(a.data<=b.data){
        tail.next=a;
        tail=a;
        a=a.next;
        }else{
        tail.next=b;
        tail=b;
        b=b.next;
        }
        
        if(a==null) tail.next=b;
        else tail.next=a;
        }
        return head;
    }
}
