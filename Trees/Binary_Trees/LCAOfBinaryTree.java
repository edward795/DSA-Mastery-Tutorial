package Trees.Binary_Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LCAOfBinaryTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        //System.out.println("lca of thye nodes 40 & 70 is "+lca(root,40,70).data);
        System.out.println();
    }

    //Naive Soln : O(n^2) - O(h)
    // static boolean findPath(Node root,ArrayList<Node> p,int n){
    //     if(root==null) return false;
    //     p.add(root);
    //     if(root.data==n) return true;
    //     if(findPath(root.left, p, n) || findPath(root.right, p, n))
    //         return true;
    //     p.remove(p.size()-1);
    //     return false;
    // }

    //Naive Soln : O(n^2) -  O(h)
    // static Node lca(Node root,int n1,int n2){
    //     ArrayList<Node> path1=new ArrayList<>();
    //     ArrayList<Node> path2=new ArrayList<>();

    //     if(findPath(root, path1, n1)==false || findPath(root,path2,n2)==false)
    //         return null;

    //     for(int i=0;i<path1.size()-1 && i<path2.size()-1;i++){
    //         if(path1.get(i)==path2.get(i)) return path1.get(i);
    //     }

    //     return null;
    // }

    //Naive Soln : O(n) - O(h)
    static Node lca(Node root,int n1,int n2){
        if(root==null) return null;
        if(root.data==n1 || root.data==n2) return root;

        Node lca1=lca(root.left,n1,n2);
        Node lca2=lca(root.right,n1,n2);

        if(lca1!=null && lca2!=null) 
            return root;

        if(lca1!=null)
            return lca1;
        else 
            return lca2;
    }
}
