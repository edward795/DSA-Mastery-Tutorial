package Trees.Binary_Trees;

public class BurnABinaryTree {
    static int res=0;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        System.out.println("Burn Time for this BT is "+burnTime(root, new Node(50), new Distance(-1)));
    }

    //TC : O(n) - O(h)
    static int burnTime(Node root,Node leaf,Distance dist){
        if(root==null) return 0;
        if(root.data==leaf.data){
            dist.val=0;
            return 1;
        }
        Distance ldist=new Distance(-1),rdist=new Distance(-1);
        int lh=burnTime(root.left, leaf, ldist);
        int rh=burnTime(root.right, leaf, rdist);
        if(ldist.val!=-1){
            dist.val=ldist.val+1;
            res=Math.max(res,lh+dist.val);
        }else if(rdist.val!=-1){
            dist.val=rdist.val+1;
            res=Math.max(res,rh+dist.val);
        }

        return Math.max(lh,rh)+1;
    }
}


class Distance{
    int val;

    Distance(int d){
        val=d;
    }
}
