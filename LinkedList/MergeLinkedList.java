package LinkedList;

public class MergeLinkedList {
    public static void main(String[] args) {
        MNode head=new MNode(10);
        MNode n1=new MNode(65);
        MNode n2=new MNode(45);
        MNode n3=new MNode(34);
        MNode n4=new MNode(7);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        printList(head);
        MNode node=mergeSort(head);
        printList(node);
    }
    static MNode mergeSort(MNode head){
        if(head==null || head.next==null) return head; 
        MNode second=splitLL(head);
        head=mergeSort(head);
        second=mergeSort(second);
        return merge(head,second);
    }

    static MNode splitLL(MNode head){
        MNode fast=head,slow=head;


        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        MNode temp=slow.next;
        slow.next=null;
        return temp;
    }

    static MNode merge(MNode first,MNode second){
        if(first==null) return second;
        if(second==null) return first;

        if(first.data<second.data){
            first.next=merge(first.next,second);
            first.next.prev=first;
            first.prev=null;
            return first;
        }else{
            second.next=merge(first,second.next);
            second.next.prev=second;
            second.prev=null;
            return second;
        }
    }

    static void printList(MNode head){
        MNode curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println();
    }
}

class MNode{
    int data;
    MNode next,prev;

    MNode(int data){
        this.data=data;
    }
}
