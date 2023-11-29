package Trees.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPairWithSum{
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println(findPair(root, 90));
    }

    //TC : O(n) - O(h)
    static boolean findPair(Node root,int x){
        if(root==null) return false;
        HashSet<Integer> hs=new HashSet<>();
        return inorder(root,hs,x);
    }

    static boolean inorder(Node root,HashSet<Integer> hs,int x){
        if(root==null) return false; 
        if(inorder(root.left,hs,x)==true) 
            return true; 
        if(hs.contains(x-root.data)) 
            return true; 
        else    
            hs.add(root.data);
        return inorder(root.right,hs,x);
    }

    //TC : O(n) - O(h)
    // static boolean findPair(Node root,int x){
    //     if(root==null) return false;
    //     ArrayList<Integer> arr=new ArrayList<>(); 
    //     inorder(root,arr);
    //     int i=0,j=arr.size()-1; 
    //     while(i<j){
    //         if(arr.get(i)==arr.get(j)) return true; 
    //         else if(arr.get(i)+arr.get(j)<x) 
    //             i++;
    //         else if(arr.get(i)+arr.get(j)>x) 
    //             j--;
    //     }
    //     return false;
    // }

    // static void inorder(Node root,ArrayList<Integer> arr){
    //     if(root!=null){
    //         inorder(root.left,arr);
    //         arr.add(root.data);
    //         inorder(root.right,arr);
    //     }
    // }
}