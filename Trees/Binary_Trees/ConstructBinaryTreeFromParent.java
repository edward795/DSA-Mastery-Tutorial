package Trees.Binary_Trees;

public class ConstructBinaryTreeFromParent{

    static Node root=null;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        int[] parent=new int[]{-1,0,0,1,1,3,5};
        root=createTree(parent);
        Node.printTree(root);
    }

    //TC : O(n^2) - O(h)
    // static Node createTree(int[] parent){
    //     int n=parent.length;
    //     Node[] created=new Node[n];
    //     for(int i=0;i<n;i++){
    //         created[i]=null;
    //     }

    //     for(int i=0;i<n;i++){
    //         createNode(parent,i,created);
    //     }
    //     return root;
    // }

    // static Node createNode(int[] parent,int i,Node[] created){
    //     if(created[i]!=null) return null;
    //     created[i]=new Node(i);
        
    //     if(parent[i]==-1){
    //         root=created[i];
    //         return null;
    //     }

    //     if(created[parent[i]]==null)
    //         createNode(parent,parent[i],created);
    //     Node p=created[parent[i]];
    //     if(p.left==null)
    //         p.left=created[i];
    //     else 
    //         p.right=created[i];
    //     return root;
    // }

    //TC : O(n) - O(h)
    static Node createTree(int[] parent){
        int n=parent.length;
        Node[] created=new Node[n];
        for(int i=0;i<n;i++){
            created[i]=new Node(i);
        }

        for(int i=0;i<n;i++){
            if(parent[i]==-1){
                root=created[i];
            }else{
                if(created[parent[i]].left==null)
                    created[parent[i]].left=created[i];
                else 
                    created[parent[i]].right=created[i];
            }
        }
        return root;
    }
}