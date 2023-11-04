package Trees.Binary_Trees;

public class BuildTreeInorderPreorder{

    static int preIndex=0;
    public static void main(String[] args) {
        int inorder[]=new int[]{40,20,50,10,30,80,70,90};
        int preorder[]=new int[]{10,20,40,50,30,70,80,90};

        Node root=constructTree(inorder, preorder, 0, inorder.length-1);
        Node.printTree(root);
    }

    //TC : O(n^2) - O(1)
    static Node constructTree(int[] inorder,int[] preorder,int is,int ie){
        if(is>ie) return null;
        Node root=new Node(preorder[preIndex++]);
        int inIndex=0;
        for(int i=is;i<=ie;i++){
            if(inorder[i]==root.data){
                inIndex=i;
                break;
            }
        }
        root.left=constructTree(inorder, preorder, is, inIndex-1);
        root.right=constructTree(inorder, preorder, inIndex+1, ie);
        return root;
    }
}