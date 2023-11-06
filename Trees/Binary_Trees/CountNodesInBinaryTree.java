package Trees.Binary_Trees;

public class CountNodesInBinaryTree {
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("No of nodes : "+countNodes(root));
    }

    //TC : O(logn*logn) -O(h)
    static int countNodes(Node root){
        if(root==null) return 0;

        int lh=0,rh=0;
        Node curr=root;
        while(curr!=null){
            lh++;
            curr=curr.left;
        }

        curr=root;
        while(curr!=null){
            rh++;
            curr=curr.right;
        }

        if(lh==rh) 
            return (int) (Math.pow(2,lh)-1);

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
