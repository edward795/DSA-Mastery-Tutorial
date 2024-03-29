package Dynamic_Programming;

public class ZeroToOneKnapsackProblem {
    public static void main(String[] args) {
        int n = 3, w = 4;
        int[] values = new int[] { 1, 2, 3 };
        int[] weight = new int[] { 4, 5, 1 };
        System.out.println("The value of max profit is " + knapsackProblem(w, weight, values, n));
    }

    // static int knapsackProblem(int w, int wt[], int[] val, int n) {
    // int memo[][] = new int[w + 1][n + 1];
    // for (int i = 0; i <= w; i++) {
    // for (int j = 0; j <= n; j++) {
    // memo[i][j] = 1;
    // }
    // }
    // return solve(w, n, wt, val, memo);
    // }

    // static int solve(int w, int n, int[] wt, int[] val, int[][] memo) {
    // if (n == 0 || w == 0)
    // return 0;
    // if (memo[w][n] != -1) {
    // return memo[w][n];
    // } else {
    // if (wt[n - 1] > w) {
    // return memo[w][n] = solve(w, n - 1, wt, val, memo);
    // } else {
    // return memo[w][n] = Math.max(solve(w, n - 1, wt, val, memo),
    // val[n - 1] + solve(w - wt[n - 1], n - 1, wt, val, memo));
    // }
    // }
    // }

    static int knapsackProblem(int w, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= w; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (wt[i - 1] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                    }
                }
            }
        }

        return dp[n][w];
    }
}
