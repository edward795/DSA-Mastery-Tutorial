package Trees.Binary_Search_Tree;

public class FloorInBSTPractice {
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println("Floor in BST is "+floorBST(root, 15));
    }

    //TC : O(h) - O(h)
    static int floorBST(Node root,int key){
        if(root==null) return -1;
        if(root.data==key) return key;
        else if(root.data<key){
            int x=floorBST(root.right,key);
            if(x>root.data) 
                return x;
            else 
                return root.data;
        }else 
            return floorBST(root.left, key);
    }
}
