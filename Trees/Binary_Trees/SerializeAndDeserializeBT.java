package Trees.Binary_Trees;

import java.util.ArrayList;

public class SerializeAndDeserializeBT {

    static int EMPTY=-1;
    static int index=0;
    public static void main(String[] args) {
        Node root=Node.getTreeRoot();
        ArrayList<Integer> arr=new ArrayList<>();
        serialize(root, arr);
        System.out.println(arr);
        Node rootTemp=deserialize(arr);
        Node.printTree(rootTemp);
    }

    //TC : O(n) - O(1)
    static void serialize(Node root,ArrayList<Integer> arr){
        if(root==null){
            arr.add(EMPTY);
            return;
        }
        arr.add(root.data);
        serialize(root.left,arr);
        serialize(root.right,arr);
    }

    //TC : O(n) -O(1)
    static Node deserialize(ArrayList<Integer> arr){
        if(index==arr.size()) return null;
        int val=arr.get(index);
        index++;

        if(val==EMPTY) return null;
        Node root=new Node(val);
        root.left=deserialize(arr);
        root.right=deserialize(arr);
        return root;
    }
}
