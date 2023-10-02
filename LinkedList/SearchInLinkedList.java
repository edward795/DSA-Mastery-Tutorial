package LinkedList;
import LinkedList.utils.Node;

public class SearchInLinkedList {
    public static void main(String[] args) {
        Node head=new Node(10);
        Node n1=new Node(20);
        Node n2=new Node(30);
        Node n3=new Node(40);
        Node n4=new Node(50);
        Node n5=new Node(60);
        Node n6=new Node(70);
        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;

        System.out.println(search(head, 50));
        System.out.println(recursiveSearch(head, 70));
    }

    //iterative search : O(n) - O(1)
    static int search(Node head,int r){
        if(head==null) return -1; 

        Node curr=head;
        int count=0;
        while(curr!=null){
            count++;
            if(curr.data==r)
                return count;
            curr=curr.next;
        }
        return -1;
    }

    //recursive search : O(n) - O(n)
    static int recursiveSearch(Node head,int r){
        if(head==null) return -1;
        if(head.data==r) return 1;

        int res=search(head.next,r);
        return res==-1?-1:res+1;
    }
}
