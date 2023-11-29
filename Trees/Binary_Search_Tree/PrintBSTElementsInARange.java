package Trees.Binary_Search_Tree;

import java.util.ArrayList;

public class PrintBSTElementsInARange {
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println(getElementsWithinARange(root));
    }

    //TC : O(n) - O(h)
    static ArrayList<Integer> getElementsWithinARange(Node root){
        ArrayList<Integer> arr=new ArrayList<>();
        getInorderArr(root, arr, 10, 30);
        return arr;
    }

    static void getInorderArr(Node root,ArrayList<Integer> arr,int low,int high){
        if(root==null) return; 
        getInorderArr(root.left,arr,low,high);
        if(root.data>=low && root.data<=high){
            arr.add(root.data);
        }
        getInorderArr(root.right,arr,low,high);
    }
}
