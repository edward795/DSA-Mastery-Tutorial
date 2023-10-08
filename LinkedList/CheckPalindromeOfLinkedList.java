package LinkedList;
import LinkedList.utils.Node;

public class CheckPalindromeOfLinkedList {
    public static void main(String[] args) {
        Node head=new Node('M');
        head.next=new Node('O');
        head.next.next=new Node('M');
       
        Node .printList(head);
        System.out.println("Is the LL palindrome?"+isPalindrome(head));
    }
        
        // static boolean isPalindrome(Node head){
        //Stack<Node> st=new Stack<>();
        //Node curr=head;
        //while(curr!=null){
        //st.add(curr);
        //curr=curr.next;
        //}
        
        //curr=head;
        //while(curr!=null){
        //if(curr.data!=st.pop().data) return false;
        //curr=curr.next;
        //}
        //return true;
        // }
        
        static Node reverse(Node head){
            Node prev=null,curr=head;
            while(curr!=null){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return prev;
        }
        
        //Efficient Soln : O(n) - O(1)
        static boolean isPalindrome(Node head){
            if(head==null) return true;
            Node slow=head,fast=head;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
    
            Node rev=reverse(slow.next);
            Node curr=head;
            while(rev!=null){
                if(curr.data!=rev.data) return false;
                curr=curr.next;
                rev=rev.next;
            }
        return true;
    }
}
