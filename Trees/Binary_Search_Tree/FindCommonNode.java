package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class FindCommonNode{
    public static void main(String[] args) {
        Node root1=Node.getBST();
        Node root2=null;
        int[] arr=new int[]{10,15,20,25,30,35};
        for(Integer i:arr) 
            root2=Node.insert(root2,i);

        System.out.println("common nodes are : ");
        for(Integer i:arr) 
            System.out.print(i+" ");
    }

    //TC : O(n1+n2) - O(h)
    // static List<Integer> findCommonNodes(Node root1,Node root2){
    //     List<Integer> arr1=new ArrayList<>();
    //     List<Integer> arr2=new ArrayList<>();
    //     List<Integer> arr=new ArrayList<>();
    //     HashSet<Integer> hs=new HashSet<>();

    //     inorder(root1,arr1);
    //     inorder(root2,arr2);

    //     for(Integer i:arr1)
    //         hs.add(i);
    //     for(Integer i:arr2){
    //         if(hs.contains(i)){
    //             arr.add(i);
    //         }
    //     }
    //     return arr;
    // }

    // static void inorder(Node root,List<Integer> arr1){
    //     if(root==null) return;
    //     inorder(root.left,arr1);
    //     arr1.add(root.data);
    //     inorder(root.right,arr1);
    // }

    //TC : O(n1+n2) : O(h)
    static ArrayList<Integer> findCommonNodes(Node root1,Node root2){
        ArrayList<Integer> arr=new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();

        while(true){
            if(root1!=null){
                s1.push(root1);
                root1=root1.left;
            }
            else if(root2!=null){
                s2.push(root2);
                root2=root2.left;
            }else if(!s1.isEmpty() && !s2.isEmpty()){
                root1=s1.peek();
                root2=s2.peek();
                if(root1.data==root2.data){
                    arr.add(root1.data);
                    s1.pop();
                    s2.pop();
                    root1=root1.right;
                    root2=root2.right;
                }else if(root1.data<root2.data){
                    s1.pop();
                    root1=root1.right;
                    root2=null;
                }else if(root1.data>root2.data){
                    s2.pop();
                    root2=root2.right;
                    root1=null;
                }
            }else 
                break;
        }
        return arr;
    }
}