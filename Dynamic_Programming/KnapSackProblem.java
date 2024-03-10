package Dynamic_Programming;

public class KnapSackProblem {
    public static void main(String[] args) {
        int[] v = new int[] { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        int W = 50;
        int n = v.length;
        System.out.println("The Max capacity of Knapsack Problem : " + KnapSackProblem(W, w, v, n));
    }

    // TC : O(2^n)
    // static int KnapSackProblem(int W, int wt[], int val[], int n) {
    // if (n == 0 || W == 0)
    // return 0;

    // if (wt[n - 1] > W)
    // return KnapSackProblem(W, wt, val, n - 1);
    // else
    // return Math.max(KnapSackProblem(W, wt, val, n - 1),
    // val[n - 1] + KnapSackProblem(W - wt[n - 1], wt, val, n - 1));
    // }

    // TC : O(n*W)
    static int KnapSackProblem(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= W; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return dp[n][W];
    }
}
