package Dynamic_Programming;

import java.util.Arrays;

public class CountWaysToReachNthStair {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int n = 4;
        // System.out.println("The ways to reach nth stair is " + fib(n));
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        // System.out.println("The ways to reach nth stair is " + fib(n, memo));
        System.out.println("The ways to reach nth stair is " + fib(n));
    }

    // O(2^n) - recursive
    // static int fib(int n) {
    // if (n == 0 || n == 1)
    // return 1;

    // return (fib(n - 1) % mod + fib(n - 2) % mod) % mod;
    // }

    // TC : O(n) - memoization
    // static int fib(int n, int[] memo) {
    // if (n == 0 || n == 1)
    // return 1;
    // if (n < 0)
    // return 0;
    // if (memo[n] != -1) {
    // return memo[n];
    // } else {
    // memo[n] = (fib(n - 1, memo) % mod + fib(n - 2, memo) % mod) % mod;
    // return memo[n];
    // }
    // }

    // TC: O(n) - bottom-up approach
    static int fib(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        return dp[n];
    }
}
