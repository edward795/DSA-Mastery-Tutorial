package Dynamic_Programming;

public class LongestCommonSubseq {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[] { 5, 8, 3, 7, 9, 1 };
        // System.out.println("The LCS of the given array is " + solve(n, arr, 0, -1));
        System.out.println("The LCS of the given array is " + solve(n, arr));
    }

    // TC : O(n)
    // static int solve(int n, int[] arr, int curr, int prev) {
    // if (curr == n)
    // return 0;
    // int take = 0;
    // if (prev == -1 || arr[curr] > arr[prev]) {
    // take = 1 + solve(n, arr, curr + 1, curr);
    // }
    // int not_take = solve(n, arr, curr + 1, prev);
    // return Math.max(take, not_take);
    // }

    // TC : O(n^2)
    // static int solve(int[] arr) {
    // int n = arr.length;
    // int[] lis = new int[n];
    // lis[0] = 1;
    // for (int i = 1; i < n; i++) {
    // lis[i] = 1;
    // for (int j = 0; j < i; j++) {
    // if (arr[j] < arr[i]) {
    // lis[i] = Math.max(lis[i], lis[j] + 1);
    // }
    // }
    // }
    // int res = lis[0];
    // for (int i = 0; i < n; i++) {
    // res = Math.max(res, lis[i]);
    // }
    // return res;
    // }

    // TC : O(logn)
    static int solve(int n, int[] arr) {
        int[] tail = new int[n];
        int len = 1;
        tail[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len] = arr[i];
                len++;
            } else {
                int c = ceilIdx(tail, 0, len - 1, arr[i]);
                tail[c] = arr[i];
            }
        }
        return len;
    }

    static int ceilIdx(int[] tail, int low, int high, int ele) {
        while (low < high) {
            int mid = (low + high) / 2;
            if (tail[mid] >= ele) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
