package Trees.Binary_Search_Tree;

import java.util.*;

public class VerticalSumInBST {
    static HashMap<Integer,Integer> hm;
    public static void main(String[] args) {
        Node root=Node.getBST();
        Node.inorder(root);
        getSumR(root, 0, hm);
        printVerticalSum(hm);
    }

    //TC : O(nloghd) - O(hd)
    static void getSumR(Node root,int hd,HashMap<Integer,Integer> hm){
        if(root==null) return;
        getSumR(root.left,hd-1,hm);
        int pSum=(hm.get(hd)==null)?0:hm.get(hd);
        hm.put(hd,pSum+root.data);
        getSumR(root.right, hd+1, hm);
    }

    static void printVerticalSum(HashMap<Integer,Integer> hm){
        for(Map.Entry i:hm.entrySet()){
            System.out.println(i.getKey()+":"+i.getValue());
        }
    }
}
