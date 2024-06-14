package Segment_Tree;

public class RangeLCMQueries {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 4, 6, 8, 16 };
        int n = 6;
        int[] st = constructST(arr, n);
        System.out.println("The lcm in the range of (0,2) : " + getLCM(st, 0, 2, n));
        update(3, 8, arr, st, n);
        System.out.println("The lcm in the range of (2,5) : " + getLCM(st, 2, 5, n));
    }

    static int constructSTUtil(int[] arr, int ss, int se, int[] st, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }
        int mid = ss + (se - ss) / 2;
        st[si] = lcm(constructSTUtil(arr, ss, mid, st, 2 * si + 1), constructSTUtil(arr, mid + 1, se, st, 2 * si + 2));
        return st[si];
    }

    static int[] constructST(int[] arr, int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) (Math.pow(2, x) - 1);
        int[] st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }

    static int getLCMRes(int ss, int se, int qs, int qe, int si, int[] st) {
        if (qs > ss || qe > se)
            return 1;
        if (qs >= ss && qe <= se)
            return st[si];

        int mid = ss + (se - ss) / 2;
        return lcm(getLCMRes(ss, mid, qs, qe, 2 * si + 1, st), getLCMRes(mid + 1, se, qs, qe, 2 * si + 2, st));
    }

    static int getLCM(int[] st, int qs, int qe, int n) {
        return getLCMRes(0, n - 1, qs, qe, 0, st);
    }

    static void updateRec(int ss, int se, int index, int si, int new_val, int[] arr, int[] st) {
        if (index < ss || index > se)
            return;

        if (index == ss && index == se) {
            arr[index] = new_val;
            st[si] = new_val;
            return;
        }

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateRec(ss, mid, index, 2 * si + 1, new_val, arr, st);
            updateRec(mid + 1, se, index, 2 * si + 2, new_val, arr, st);
            int left = st[2 * si + 1];
            int right = st[2 * si + 2];
            st[si] = lcm(left, right);
        }
    }

    static void update(int index, int new_val, int[] arr, int[] st, int n) {
        updateRec(0, n - 1, index, 0, new_val, arr, st);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;

        return gcd(b, a % b);
    }
}