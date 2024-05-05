package Segment_Tree;

public class SegmentTree {
    static int[] tree;

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 40 };
        constructBST(0, arr.length, 0, arr);
        for (Integer i : tree)
            System.out.println(tree[i] + "->");

        int new_val = 5;
        int diff = new_val - arr[0];
    }

    static int constructBST(int ss, int se, int si, int[] arr) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }

        int mid = (ss + se) / 2;
        tree[si] = constructBST(ss, mid, 2 * si + 1, arr) + constructBST(mid + 1, se, 2 * si + 2, arr);
        return tree[si];
    }

    static int getSumRec(int qs, int qe, int ss, int se, int si) {
        if (se < qs || ss > qe)
            return 0;
        if (qs <= ss && qe >= se)
            return tree[si];
        int mid = (ss + se) / 2;
        return getSumRec(qs, qe, ss, mid, 2 * si + 1) + getSumRec(qs, qe, mid + 1, se, 2 * si + 2);
    }

    static void updateRec(int ss, int se, int i, int si, int diff) {
        if (i < ss || i > se)
            return;
        tree[si] = tree[si] + diff;
        if (se > ss) {
            int mid = (ss + se) / 2;
            updateRec(ss, mid, i, 2 * si + 1, diff);
            updateRec(mid + 1, se, i, 2 * si + 2, diff);
        }
    }

}