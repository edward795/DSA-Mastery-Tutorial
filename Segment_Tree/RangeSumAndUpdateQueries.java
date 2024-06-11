package Segment_Tree;

public class RangeSumAndUpdateQueries {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 7, 9, 8 };
        int N = 6;
        int[] st = constructST(arr, N);
        System.out.println("Sum in range of (0,2) : " + getSum(st, 0, 2, N));
        update(arr, st, N, 3, 17);
        System.out.println("Sum in range of (0,5) : " + getSum(st, 0, 2, N));
    }

    static int getSumUtil(int ss, int se, int qs, int qe, int si, int[] st) {
        if (qs > se || qe < ss)
            return 0;

        if (qs >= ss && qe <= se)
            return st[si];

        int mid = ss + (se - ss) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1, st) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2, st);

    }

    static int getSum(int[] st, int l, int r, int n) {
        return getSumUtil(0, n - 1, l, r, 0, st);
    }

    static void updateUtil(int ss, int se, int i, int si, int val, int[] arr, int[] st) {
        if (i < ss || i > se)
            return;
        st[si] = st[si] + val;
        if (ss < se) {
            int mid = ss + (se - ss) / 2;
            updateUtil(ss, mid, i, 2 * si + 1, val, arr, st);
            updateUtil(mid + 1, se, i, 2 * si + 2, val, arr, st);
        }
    }

    static void update(int[] arr, int[] st, int n, int index, int val) {
        updateUtil(0, n - 1, index, 0, val, arr, st);
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
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        int[] st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }

}
