package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Merge2BSTs {
    public static void main(String[] args) {
        Node root1=Node.getBST();
        Node root2=Node.getBST();
        System.out.println("The merged list is "+merge(root1, root2));
    }

    //TC : O(n1+n2) - O(h1+h2)
    // static List<Integer> merge(Node root1,Node root2){
    //     if(root1==null && root2==null) return null;
    //     ArrayList<Integer> arr=new ArrayList<>();
    //     inorder(root1,arr);
    //     inorder(root2,arr);
    //     Collections.sort(arr);
    //     return arr;
    // }

    // static void inorder(Node root,ArrayList<Integer> arr){
    //     if(root==null) return;
    //     inorder(root.left,arr);
    //     arr.add(root.data);
    //     inorder(root.right,arr);
    // }

    static List<Integer> merge(Node root1,Node root2){
        if(root1==null && root2==null) return null;
        List<Integer> arr=new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();

        while(root1!=null || root2!=null || !s1.isEmpty() || !s2.isEmpty()){
            while(root1!=null){
                s1.push(root1);
                root1=root1.left;
            }

            while(root2!=null){
                s2.push(root2);
                root2=root2.left;
            }

            if(s2.isEmpty() || (!s1.isEmpty() && s1.peek().data<=s2.peek().data)){
                root1=s1.peek();
                s1.pop();
                arr.add(root1.data);
                root1=root1.right;
            }else{
                root2=s2.peek();
                s2.pop();
                arr.add(root2.data);
                root2=root2.right;
            }
        }
        return arr;
    }
}
