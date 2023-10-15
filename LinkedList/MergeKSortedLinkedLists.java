package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import LinkedList.utils.Node;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        Node head1=new Node(1);
        Node n1=new Node(2);
        Node n2=new Node(3);

        head1.next=n1;
        n1.next=n2;

        Node head2=new Node(4);
        Node n3=new Node(5);
        head2.next=n3;

        Node head3=new Node(7);
        Node n4=new Node(8);
        head3.next=n4;

        System.out.println("separate LL's are : ");
        Node.printList(head1);
        Node.printList(head2);
        Node.printList(head3);

        Node[] arr=new Node[]{head1,head2,head3};
        System.out.println("Merged LL : ");
        Node.printList(mergeList(arr, 3));
    }

    // TC : O(nlogn)
    // static Node mergeList(Node[] arr,int k){
    //     ArrayList<Integer> res=new ArrayList<>();
    //     for(Node n:arr){
    //         Node curr=n;
    //         while(curr!=null){
    //             res.add(curr.data);
    //             curr=curr.next;
    //         }
    //     }
    //     Collections.sort(res);
    //     Node temp=new Node(-1);
    //     Node curr_res=temp;
    //     for(Integer i:res){
    //         temp.next=new Node(i);
    //         temp=temp.next;
    //     }
    //     return curr_res.next;
    // }

    //TC : O(nk)
    static Node mergeList(Node[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            Node curr=arr[i];
            while(curr!=null){
                pq.add(curr.data);
                curr=curr.next;
            }
        }

        Node temp=new Node(-1);
        Node res=temp;
        while(!pq.isEmpty()){
            temp.next=new Node(pq.poll());
            temp=temp.next;
        }
        return res.next;
    }

}
