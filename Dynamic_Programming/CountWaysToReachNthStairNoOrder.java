package Dynamic_Programming;

public class CountWaysToReachNthStairNoOrder {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("No of ways to reach nth floor without counting order : " + countWays(n));
    }

    // TC : O(1)
    // static int countWays(int n) {
    // return (n / 2 + 1);
    // }

    // TC : O(n)
    static long countWays(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
