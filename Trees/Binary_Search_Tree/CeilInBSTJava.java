package Trees.Binary_Search_Tree;

public class CeilInBSTJava {
    public static void main(String[] args) {
        Node tree=Node.getBST();
        System.out.println(findCeil(tree, 37));
    }

    //TC : O(h) - O(h)
    static int findCeil(Node root,int key){
        if(root==null) return -1;
        if(root.data==key) return key;
        else if(root.data<key){
            return findCeil(root.right,key);
        }else{
            int x=findCeil(root.left,key);
            if(x==-1){
                return root.data;
            }else{
                return x;
            }
        }
    }
}
