package Dynamic_Programming;

import java.util.Arrays;

public class NCRCombinations {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int n = 3, r = 2;
        // int[][] memo = new int[n + 1][r + 1];
        // for (int i = 0; i < n + 1; i++) {
        // Arrays.fill(memo[i], -1);
        // }
        // System.out.println("The ncr of 3c2 is " + solve(n, r, memo));
        System.out.println("The ncr od 3c2 is " + ncrModP(n, r));
    }

    // TC : memoized soln
    // static int solve(int n, int r, int[][] memo) {
    // if (r > n)
    // return 0;
    // if (r == 0 || r == n)
    // return 1;

    // if (memo[n][r] != -1)
    // return memo[n][r];
    // else
    // return memo[n][r] = (solve(n - 1, r - 1, memo) % mod + solve(n - r, r, memo)
    // % mod) % mod;
    // }

    // TC : O(n*r) - dp based soln
    // static int ncrModP(int n, int r) {
    // int[][] dp = new int[n + 1][r + 1];
    // for (int i = 0; i <= n; i++) {
    // for (int j = 0; j <= r; j++) {
    // dp[i][j] = -1;
    // }
    // }

    // for (int i = 0; i <= n; i++)
    // dp[i][0] = 1;

    // for (int i = 0; i <= n; i++) {
    // for (int j = 0; j <= r; j++) {
    // if (i == j)
    // dp[i][j] = 1;
    // }
    // }

    // for (int i = 2; i <= n; i++) {
    // for (int j = 1; j <= r; j++) {
    // if (dp[i][j] == -1 && i > j) {
    // dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
    // }
    // }
    // }

    // return dp[n][r] == -1 ? 0 : dp[n][r];
    // }

    // Efficient Soln - O(r)
    static int ncrModP(int n, int r) {
        int[] dp = new int[r + 1];
        if (r > n)
            return 0;
        if (n - r < r)
            r = n - r;
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(r, i); j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % mod;
            }
        }
        return dp[r];
    }
}