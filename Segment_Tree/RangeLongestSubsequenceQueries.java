package Segment_Tree;

public class RangeLongestSubsequenceQueries {
    public static void main(String[] args) {
        String str = "())(())(())(";
        int n = 12;
        Node[] st = constructST(str, 12);
        System.out.println("Max Longest bracket seq in (3,6) : " + getLongestSequence(st, str, 3, 6, n));
        System.out.println("Max Longest bracket seq in (3,6) : " + getLongestSequence(st, str, 0, 11, n));

    }

    public static void constructSTUtil(String str, int ss, int se, Node[] st, int si) {
        st[si] = new Node();
        if (ss == se) {
            st[si].pairs = 0;
            if (str.charAt(ss) == '(') {
                st[si].open = 1;
            } else {
                st[si].closed = 1;
            }
            return;
        }

        int mid = ss + (se - ss) / 2;
        constructSTUtil(str, ss, mid, st, 2 * si + 1);
        constructSTUtil(str, mid + 1, se, st, 2 * si + 2);
        st[si] = merge(st[2 * si + 1], st[2 * si + 2]);
    }

    public static Node[] constructST(String str, int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        Node[] st = new Node[max_size];
        constructSTUtil(str, 0, n - 1, st, 0);
        return st;
    }

    public static Node merge(Node leftChild, Node rightChild) {
        Node parentNode = new Node();
        int minMatched = Math.min(leftChild.open, rightChild.closed);
        parentNode.pairs = leftChild.pairs + rightChild.pairs + minMatched;
        parentNode.open = leftChild.open + rightChild.open - minMatched;
        parentNode.closed = leftChild.closed + rightChild.closed - minMatched;
        return parentNode;
    }

    public static int getLongestSequence(Node[] st, String str, int qs, int qe, int n) {
        Node node = queryUtil(0, n - 1, qs, qe, 0, st);
        return 2 * node.pairs;
    }

    public static Node queryUtil(int ss, int se, int qs, int qe, int si, Node[] st) {
        if (ss > qe || se < qe)
            return new Node();

        if (ss >= qs && se <= qe)
            return st[si];
        int mid = ss + (se - ss) / 2;
        Node left = queryUtil(ss, mid, qs, qe, 2 * si + 1, st);
        Node right = queryUtil(mid + 1, se, qs, qe, 2 * si + 2, st);
        return merge(left, right);
    }
}

class Node {
    int pairs;
    int open;
    int closed;

    Node() {
        open = closed = pairs = 0;
    }
}
