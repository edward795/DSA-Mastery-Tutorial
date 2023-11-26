package Trees.Binary_Search_Tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
    public static void main(String[] args) {
        Node root = Node.getBST();
        verticalOrder(root);
        
    }

    //TC : O(n) 
    static void verticalOrder(Node root) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Pair> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            if (mp.containsKey(hd)) {
            } else {
                mp.put(hd, new Pair(curr,hd));
            }
            if (curr.left != null)
                q.add(new Pair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new Pair(curr.right, hd + 1));
        }

        for (Map.Entry<Integer, Pair> i : mp.entrySet()) {
            System.out.print(i.getValue().node.data+" ");
        }
    }
}

class Pair {
    int hd;
    Node node;

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }

    public void add(int data) {
    }
}
