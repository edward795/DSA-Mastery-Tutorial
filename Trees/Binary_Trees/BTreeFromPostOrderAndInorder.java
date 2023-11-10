package Trees.Binary_Trees;

public class BTreeFromPostOrderAndInorder {
    public static void main(String[] args) {
        int[] inorder=new int[]{4,8,2,5,1,6,3,7};
        int[] postorder=new int[]{8,4,5,2,6,7,3,1};

        Node root=buildTree(inorder, postorder, inorder.length);
        Node.printTree(root);
    }

    //TC : O(n^2) - O(n)
    static Node buildTree(int inorder[],int postorder[],int n){
        index ind=new index(n-1);
        return helper(inorder,postorder,0,n-1,ind);
    }

    static Node helper(int[] inorder,int[] postorder,int is,int es,index ind){
        if(ind.preIndex<0 || is>es) return null;

        Node root=new Node(postorder[ind.preIndex--]);
        int inIndex=0;
        for(int i=is;i<=es;i++){
            if(inorder[i]==root.data){
                inIndex=i;
                break;
            }
        }
        root.right=helper(inorder, postorder, inIndex+1, es, ind);
        root.left=helper(inorder, postorder, is, inIndex-1, ind);
        return root;
    }
    
}

class index{
    int preIndex;

    index(int i){
        preIndex=i;
    }
}
