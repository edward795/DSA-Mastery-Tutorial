package LinkedList;

import LinkedList.utils.Node;

public class addTwoLists {
    public static void main(String[] args) {
        Node head1=new Node(1);
        Node n1=new Node(9);
        Node n2=new Node(3);

        head1.next=n1;
        n1.next=n2;

        Node head2=new Node(2);
        Node n4=new Node(5);
        Node n5=new Node(6);

        head2.next=n4;
        n4.next=n5;

        Node.printList(head1);
        Node.printList(head2);

        Node sumHead=getSum(head1, head2);
        Node.printList(sumHead);
    }

    //TC : O(n)
    static Node getSum(Node head1,Node head2){
        Node first=reverseList(head1);
        Node second=reverseList(head2);

        Node dummy=new Node(-1);
        Node temp=dummy;
        int carry=0;
        while(first!=null || second!=null || carry==1){
            int sum=0;
            if(first!=null){
                sum+=first.data;
                first=first.next;
            }

            if(second!=null){
                sum+=second.data;
                second=second.next;
            }

            sum+=carry;
            carry=sum/10;
            Node newNode=new Node(sum%10);
            temp.next=newNode;
            temp=temp.next;
        }
        return reverseList(dummy.next);
    }

    static Node reverseList(Node head){
        Node prev=null,curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
