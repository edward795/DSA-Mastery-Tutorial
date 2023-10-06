package LinkedList;

import java.util.HashSet;
import LinkedList.utils.Node;

public class IntersectionPointOfLinkedLists {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;



        Node head1=new Node(60);
        Node n5=new Node(70);
        head1.next=n5;
        n5.next=n3; // Node with data 40 is the intersection point


        System.out.println("Intersection Point is "+printIntersection(head,head1));
    }

    //Naive Soln : O(m+n) - O(n)
    // static int printIntersection(Node head,Node head1){
    //     HashSet<Node> set=new HashSet<>();
    //     Node curr=head;
    //     while(curr!=null){
    //         set.add(curr);
    //         curr=curr.next;
    //     }

    //     curr=head1;
    //     while(curr!=null){
    //         if(set.contains(curr)) return curr.data;
    //         set.add(curr);
    //         curr=curr.next;
    //     }
    //     return -1;
    // }

    //Efficient Soln :O(m+n) - O(1)
    static int printIntersection(Node head1,Node head2){
        int c1=0,c2=0,d=0;
        Node curr=head1;
        while(curr!=null){
            c1++;
            curr=curr.next;
        }

        curr=head2;
        while(curr!=null){
            c2++;
            curr=curr.next;
        }

        d=Math.abs(c1-c2);
        curr=c1>c2?head1:head2;
        Node temp=curr==head1?head2:head1;

        for(int i=0;i<d&&curr!=null;i++){
            curr=curr.next;
        }

        while(curr!=null && temp!=null){
            if(curr.data==temp.data) return curr.data;
            curr=curr.next;
            temp=temp.next;
        }
        return -1;
    }

    //Solution 3 use a visited field in the node
}

