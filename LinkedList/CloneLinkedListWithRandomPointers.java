package LinkedList;

import java.util.HashMap;

import LinkedList.utils.Node;

public class CloneLinkedListWithRandomPointers {
    public static void main(String[] args) {
        RNode head=new RNode(10);
        RNode n1=new RNode(20);
        RNode n2=new RNode(30);
        RNode n3=new RNode(40);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        head.random=n2;
        n1.random=n3;
        n2.random=n3;

        
    }

    //Naive Soln : O(n) - O(n)
    // static RNode cloneLinkedList(RNode head){
    //     HashMap<RNode,RNode> hm=new HashMap<>();
    //     for(RNode curr=head;curr!=null;curr=curr.next)
    //         hm.put(curr,new RNode(curr.data));
            
    //     for(RNode curr=head;curr!=null;curr=curr.next){
    //         RNode clone=hm.get(curr);
    //         clone.next=hm.get(curr.next);
    //         clone.random=hm.get(curr.random);
    //     }
    //     return hm.get(head);
    // }

    //Efficient Soln : O(n) - O(1)
    static RNode cloneLinkedList(RNode head){
        RNode curr=head;
        while(curr!=null){
            RNode next=curr.next;
            curr.next=new RNode(curr.data);
            curr.next.next=next;
            curr=next;
        }

        for(curr=head;curr!=null;curr=curr.next.next)
            curr.next.random=curr.random==null?null:curr.random;

        RNode head2=head.next;
        RNode clone=head2;
        for(curr=head2;curr!=null;curr=curr.next){
            curr.next=curr.next.next;
            clone.next=clone.next!=null?clone.next.next:null;
            clone=clone.next;
        }
        return head2;
        }
    }

class RNode{
    int data;
    RNode next,random;

    RNode(int data){
        this.data=data;
    }
}