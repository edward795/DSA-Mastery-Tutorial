package Segment_Tree;

public class RangeSumAndUpdateQueries {
    public static void main(String[] args) {

    }

    static int getSumUtil(int ss, int se, int qs, int qe, int si, int[] st) {
        if (qs > se || qe < ss)
            return 0;

        if (qs >= ss && qe <= se)
            return st[si];

    }

    static int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        int mid = ss + (se - ss) / 2;
        st[si] = constructSTUtil(arr, ss, mid, st, 2 * si + 1) + constructSTUtil(arr, mid + 1, se, st, 2 * si + 2);
        return st[si];
    }

    static int[] constructST(int[] arr, int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = (int) Math.pow(2, x) - 1;
        int[] st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }

}
