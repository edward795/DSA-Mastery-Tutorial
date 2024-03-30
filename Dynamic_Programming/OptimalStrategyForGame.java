package Dynamic_Programming;

public class OptimalStrategyForGame {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 3, 7, 10 };
        int n = 4;
        System.out.println("The max sum profit you can get is : " + countMaximum(arr, n));
    }

    // static long countMaximum(int[] arr, int n) {
    // int sum = 0;
    // for (int i = 0; i < n; i++) {
    // sum += arr[i];
    // }
    // return solve(arr, 0, n - 1, sum);
    // }

    // // TC : O(2^n) recursive
    // static long solve(int[] arr, int i, int j, int sum) {
    // if (j == i + 1)
    // return Math.max(arr[i], arr[j]);

    // return Math.max(sum - solve(arr, i + 1, j, sum - arr[i]), sum - solve(arr, i,
    // j - 1, sum - arr[j]));
    // }

    // static long countMaximum(int[] arr, int n) {
    // long[][] memo = new long[n + 1][n + 1];
    // for (int i = 0; i <= n; i++) {
    // for (int j = 0; j <= n; j++) {
    // memo[i][j] = -1;
    // }
    // }
    // return solve(arr, 0, n - 1, memo);
    // }

    // // TC : O(n)
    // static long solve(int[] arr, int i, int j, long[][] memo) {
    // if (i + 1 == j)
    // return Math.max(arr[i], arr[j]);
    // if (memo[i][j] != -1)
    // return memo[i][j];
    // else
    // return memo[i][j] = Math.max(
    // (arr[i] + Math.min(solve(arr, i + 2, j, memo), solve(arr, i + 1, j - 1,
    // memo))),
    // (arr[j] + Math.min(solve(arr, i + 1, j - 1, memo), solve(arr, i, j - 2,
    // memo))));
    // }

    // TC : O(n )
    static long countMaximum(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);

        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
            }
        }
        return dp[0][n - 1];
    }
}
