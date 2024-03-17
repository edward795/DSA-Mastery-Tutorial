package Dynamic_Programming;

public class MinPagesAllotted {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30 };
        int k = 1;
        System.out.println("The max of min no pages allocated : " + minPages(arr, arr.length, k));
    }

    // TC : O(2^n)
    // static int minPages(int arr[], int n, int k) {
    // if (k == 1)
    // return sum(arr, 0, n - 1);
    // if (n == 1)
    // return arr[0];
    // int res = Integer.MAX_VALUE;
    // for (int i = 1; i < n; i++)
    // res = Math.min(res, Math.max(minPages(arr, n - 1, k - 1), sum(arr, i, n -
    // 1)));
    // return res;
    // }

    // TC : O(n^2*k)
    static int minPages(int[] arr, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            dp[i][1] = sum(arr, 0, n - 1);
        for (int j = 0; j <= k; j++)
            dp[1][j] = arr[0];

        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 1; p < j; p++) {
                    dp[i][j] = Math.min(res, Math.max(dp[i - 1][j - 1], sum(arr, p, i - 1)));
                }
                dp[i][j] = res;
            }
        }
        return dp[n][k];
    }

    static int sum(int[] arr, int b, int e) {
        int sum = 0;
        for (int i = b; i <= e; i++)
            sum += arr[i];
        return sum;
    }
}
