package Trees.Binary_Search_Tree;

public class CountBSTNodesInRange {
    public static void main(String[] args) {
        Node root=Node.getBST();
        System.out.println("count of nodes in the given range is "+getCount(root));
    }

    //TC : O(n) - O(h)
    // static int getCount(Node root){
    //     int count=0;
    //     inOrderRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE, count);
    //     return count;
    // }

    // static void inOrderRange(Node root,int l,int h,int count){
    //     if(root==null) return;
    //     if(root.data>=l && root.data<=h){
    //         count++;
    //         inOrderRange(root.left, l, h, count);
    //         inOrderRange(root.right, l, h, count);
    //     }else if(root.data<l) 
    //         inOrderRange(root.right, l, h, count);
    //     else 
    //         inOrderRange(root.left, l, h, count);
    // }

    //TC : O(n) - O(h)
    static int inOrderRange(Node root,int l,int h){
        if(root==null) return 0;
        boolean flag=false;
        int x=inOrderRange(root.left, l, h);
        if(root.data>=l && root.data<=h) flag=true;
        int y=inOrderRange(root.right, l, h);
        if(flag==true){
            return x+y+1;
        }
        return x+y;
    }

    static int getCount(Node root){
        return inOrderRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
