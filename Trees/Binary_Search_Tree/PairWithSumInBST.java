package Trees.Binary_Search_Tree;
import java.util.*;

public class PairWithSumInBST {
    // static ArrayList<Integer> arr;

    static HashSet<Integer> h;
    public static void main(String[] args) {
        Node root=Node.getBST();
        // inorder(root,arr);
        // System.out.println("Is the sum presentin the array "+pairWithSum(arr, 70));
        System.out.println("Is the sum present in the array "+pairWithSum(root,35,h));
    }

    //Naive Soln : O(n) - O(n)
    // static void inorder(Node root,ArrayList<Integer> arr){
    //     if(root!=null){
    //         inorder(root.left,arr);
    //         arr.add(root.data);
    //         inorder(root.right,arr);
    //     }
    // }

    // static boolean pairWithSum(ArrayList<Integer> arr,int sum){
    //     HashSet<Integer> h=new HashSet<>();
    //     for(int i=0;i<arr.size();i++){
    //         if(h.contains(sum-arr.get(i))) return true;
    //         h.add(arr.get(i));
    //     }
    //     return false;
    // }
    
    //TC : O(n) - O(h)
    static boolean pairWithSum(Node root,int sum,HashSet<Integer> h){
        if(root==null) return false;
        if(pairWithSum(root.left, sum, h)==true) return true;
        if(h.contains(sum-root.data))
            return true;
        else
            h.add(root.data);
        return pairWithSum(root.right, sum, h);
    }
}
