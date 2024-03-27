package Dynamic_Programming;

import java.util.Arrays;

public class MaxCutsInRope {
    public static void main(String[] args) {
        int n = 5;
        int x = 5, y = 3, z = 2;
        int[] memo = new int[n];
        // System.out.println("The max cuts possible in a rope cutting problem is " +
        // maximizeCuts(n, x, y, z, memo));
        System.out.println("The max cuts possible in a rope cutting problem is " + maximizeCuts(n, x, y, z));
    }

    // TC : O(3^n)
    // static int maximizeCuts(int n, int x, int y, int z) {
    // if (n == 0)
    // return 0;
    // if (n < 0)
    // return Integer.MIN_VALUE;

    // return Math.max(1 + maximizeCuts(n - x, x, y, z),
    // Math.max(1 + maximizeCuts(n - y, x, y, z), 1 + maximizeCuts(n - z, x, y,
    // z)));
    // }

    // TC : O(n)
    // static int maximizeCuts(int n, int a, int b, int c, int[] memo) {
    // if (n == 0)
    // return 0;
    // if (n < 0)
    // return Integer.MIN_VALUE;
    // if (memo[n] != -1) {
    // return memo[n];
    // } else {
    // memo[n] = Math.max(1 + maximizeCuts(n - a, a, b, c, memo),
    // Math.max(1 + maximizeCuts(n - b, a, b, c, memo), 1 + maximizeCuts(n - c, a,
    // b, c, memo)));
    // return memo[n];
    // }
    // }

    // TC : O(n)
    static int maximizeCuts(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i - a >= 0)
                dp[i] = Math.max(dp[i], dp[i - a] + 1);
            if (i - b >= 0)
                dp[i] = Math.max(dp[i], dp[i - b] + 1);
            if (i - c >= 0)
                dp[i] = Math.max(dp[i], dp[i - c] + 1);
        }
        return dp[n] < 0 ? 0 : dp[n];
    }
}
