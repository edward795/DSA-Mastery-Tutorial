package Segment_Tree;

public class RangeMinMaxQueries {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 7, 5, 9, 1 };
        int N = 6, Q = 3;
        System.out.println("st created : " + constructST(arr, N));

        PII[] st = constructST(arr, N);
        // queries : getMinMax(0,2)
        // getMinMax(3,19)
        // getMinMax(0,5)

        PII ans = getMinMax(st, arr, N, 0, 2);
        System.out.println("min & max in (0,2) are : " + ans.first + ":" + ans.second);

        PII ans2 = getMinMax(st, arr, N, 3, 6);
        System.out.println("min & max in (3,6) are : " + ans2.first + ":" + ans2.second);

        updateUtil(0, N - 1, 2, 0, arr, st, 9);

        PII ans3 = getMinMax(st, arr, N, 0, 4);
        System.out.println("min & max in (3,6) are : " + ans3.first + ":" + ans3.second);

    }

    static void constructSTUtil(int[] arr, int ss, int se, PII st[], int si) {
        st[si] = new PII();
        if (ss == se) {
            st[si].first = st[si].second = arr[ss];
            return;
        }
        int mid = ss + (se - ss) / 2;
        constructSTUtil(arr, ss, mid, st, 2 * si + 1);
        constructSTUtil(arr, mid + 1, se, st, 2 * si + 2);
        st[si].first = Math.min(st[2 * si + 1].first, st[2 * si + 2].first);
        st[si].second = Math.max(st[2 * si + 1].first, st[2 * si + 2].second);
        return;
    }

    static PII[] constructST(int[] arr, int n) {
        int x = (int) Math.ceil(Math.log(n) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        PII st[] = new PII[max_size];
        constructSTUtil(arr, 0, n - 1, st, 0);
        return st;
    }

    static void maxMinUtil(int ss, int se, int qs, int qe, int si, PII st[], PII ans) {
        if (ss > qe || se < qs)
            return;
        if (qs <= ss && qe >= se) {
            ans.first = Math.min(ans.first, st[si].first);
            ans.second = Math.max(ans.second, st[si].second);
            return;
        }

        int mid = ss + (se - ss) / 2;
        maxMinUtil(ss, mid, qs, qe, 2 * si + 1, st, ans);
        maxMinUtil(mid + 1, se, qs, qe, 2 * si + 2, st, ans);
        return;
    }

    static void updateUtil(int ss, int se, int i, int si, int[] arr, PII st[], long new_val) {
        if (i < ss || i > se)
            return;
        if (ss == se) {
            st[si].first = new_val;
            st[si].second = new_val;
            return;
        }

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateUtil(ss, mid, i, 2 * si + 1, arr, st, new_val);
            updateUtil(mid + 1, se, i, 2 * si + 2, arr, st, new_val);
            st[si].first = Math.min(st[2 * si + 1].first, st[2 * si + 2].first);
            st[si].second = Math.min(st[2 * si + 1].second, st[2 * si + 2].second);
        }
    }

    // static void updateValue(int[] arr, PII st[], int n, int index, long new_val)
    // {
    // updateUtil(0, n - 1, index, 0, arr, st, new_val);
    // }

    static PII getMinMax(PII st[], int[] arr, int n, int qs, int qe) {
        PII ans = new PII();
        ans.first = Integer.MAX_VALUE;
        ans.second = Integer.MIN_VALUE;
        maxMinUtil(0, n - 1, qs, qe, 0, st, ans);
        if (ans.first == Integer.MAX_VALUE || ans.second == Integer.MIN_VALUE) {
            ans.first = -1;
            ans.second = -1;
            return ans;
        }
        return ans;
    }
}

class PII {
    public long first;
    public long second;
}