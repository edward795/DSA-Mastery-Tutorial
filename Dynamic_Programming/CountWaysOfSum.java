package Dynamic_Programming;

import java.util.Arrays;

public class CountWaysOfSum {
    public static void main(String[] args) {
        int n = 5;
        // System.out.println("The sum to n terms is " + solve(n, n - 1));
        System.out.println("The sum of n terms is " + solve(n));
    }

    // TC : O(n*n)
    static int solve(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if ((i - 1) <= j)
                    dp[i][j] += dp[i][j - (i - 1)];
            }
        }
        return dp[n][n];
    }

    // static int solve(int n) {
    // int[] table = new int[n + 1];
    // Arrays.fill(table, 0);
    // table[0] = 1;
    // for (int i = 1; i < n; i++) {
    // for (int j = i; j <= n; j++) {
    // table[j] += table[j - i];
    // }
    // }
    // return table[n];
    // }

    // static int solve(int sum, int n) {
    // if (sum == 0)
    // return 1;

    // if (sum < 0)
    // return 0;

    // if (n == 0)
    // return 0;
    // return solve(sum - n, n) + solve(sum, n - 1);
    // }
}
