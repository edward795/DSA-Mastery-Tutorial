package Segment_Tree;

public class RangeGCDQueries {
    public static void main(String[] args) {
        int N = 6;
        int Q = 3;
        int[] arr = new int[] { 2, 3, 4, 6, 8, 16 };
        int[] st = constructSegmentTree(arr);
        int gcd = findRangeGcd(0, 2, st, N);
        System.out.println("GCD in range (0,2) : " + gcd);
        updateValue(3, 8, arr, st, N);
        int gcd1 = findRangeGcd(2, 5, st, N);
        System.out.println("GCD in range (2,5) : " + gcd1);

    }

    public static int[] constructSegmentTree(int[] arr) {
        int height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
        int size = 2 * (int) Math.pow(2, height) - 1;
        int[] st = new int[size];
        constructST(arr, st, 0, arr.length - 1, 0);
        return st;
    }

    public static int constructST(int[] arr, int[] st, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = gcd(constructST(arr, st, ss, mid, 2 * si + 1), constructST(arr, st, mid + 1, se, 2 * si + 2));
        return st[si];
    }

    public static int findRangeRec(int[] st, int ss, int se, int qs, int qe, int si) {
        if (qs > se || qe < ss)
            return 0;

        if (ss >= qs && se <= qe)
            return st[si];

        int mid = (ss + se) / 2;
        int left = findRangeRec(st, ss, mid, qs, qe, 2 * si + 1);
        int right = findRangeRec(st, ss, mid, qs, qe, 2 * si + 2);
        return gcd(left, right);
    }

    public static void updateRec(int[] st, int ss, int se, int index, int new_val, int si) {
        if (index < ss || index > se)
            return;
        st[si] = new_val;

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateRec(st, ss, mid, index, new_val, 2 * si + 1);
            updateRec(st, mid + 1, se, index, new_val, 2 * si + 2);
            int left = st[2 * si + 1];
            int right = st[2 * si + 2];
            int res = gcd(left, right);
            st[si] = res;
        }
    }

    public static int findRangeGcd(int l, int r, int st[], int n) {
        return findRangeRec(st, 0, n - 1, l, r, 0);
    }

    public static void updateValue(int index, int new_val, int[] arr, int[] st, int n) {
        arr[index] = new_val;
        updateRec(st, 0, n - 1, index, new_val, 0);
    }

    static int gcd(int a, int b) {
        if (a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
