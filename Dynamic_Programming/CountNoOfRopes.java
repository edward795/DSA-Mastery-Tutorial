package Dynamic_Programming;

public class CountNoOfRopes {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int n = 4;
        System.out.println("The no: of ways to reach the top : " + countWays(n));
    }

    // TC : O(n)
    static long countWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (n == 3)
            return 4;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod + dp[i - 3] % mod) % mod;
        }
        return dp[n];
    }
}
