package Dynamic_Programming;

public class CoinChangeProblemII {
    public static void main(String[] args) {
        int[] coins = new int[] { 2, 5, 3, 6 };
        int sum = 10, n = 3;
        // long[] memo = new long[4];
        // System.out.println("The change of coins : " + coinsRec(coins, n, sum, memo));
        System.out.println("The change of coins : " + minimumNoOfCoins(coins, n, sum));
    }

    // TC : O(2^n)
    // public static long coinsRec(int[] coins, int n, int sum, long[] memo) {
    // if (memo[sum] != -1) {
    // return memo[sum];
    // } else {
    // if (sum == 0)
    // return 0;
    // if (sum < 0)
    // return Long.MAX_VALUE;
    // long res = Long.MAX_VALUE;
    // for (int i = 0; i < n; i++) {
    // long sub_res = coinsRec(coins, n, sum - coins[i], memo);
    // if (sub_res != Long.MAX_VALUE) {
    // res = Math.min(res, sub_res + 1);
    // }
    // }
    // return memo[sum];
    // }
    // }

    // TC : O(n)
    public static long minimumNoOfCoins(int[] coins, int n, int value) {
        long[] dp = new long[value + 1];
        for (int i = 0; i <= value; i++) {
            dp[i] = Long.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= value; i++) {
            for (int j = 0; j <= n; j++) {
                if (coins[j] <= i) {
                    long sub_res = dp[i - coins[j]];
                    if (sub_res != Long.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], sub_res + 1);
                    }
                }
            }
        }

        return dp[value] == Long.MAX_VALUE ? -1 : dp[value];
    }
}
