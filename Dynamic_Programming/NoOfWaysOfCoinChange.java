package Dynamic_Programming;

public class NoOfWaysOfCoinChange {
    public static void main(String[] args) {
        int[] coins = new int[] { 2, 5, 3, 6 };
        int n = coins.length - 1;
        int sum = 10;
        System.out.println("No: of ways of adding up a coin : " + noOfWays(coins, n, sum));
    }

    // TC : O(n*m)
    static long noOfWays(int[] coins, int n, int sum) {
        long[][] dp = new long[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 0; j <= sum; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
