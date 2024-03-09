package Dynamic_Programming;

public class MinCoinsToMakeValue {
    public static void main(String[] args) {
        int[] coins = new int[] { 25, 10, 5 };
        int val = 30;
        int n = coins.length - 1;
        System.out.println("Minimum coins to make a value : " + getMin(coins, n, val));
    }

    // TC : O(n) - recursive
    // static int getMin(int[] coins, int n, int val) {
    // if (val == 0)
    // return 0;
    // int res = Integer.MAX_VALUE;
    // for (int i = 0; i < n; i++) {
    // if (coins[i] <= val) {
    // int sub_res = getMin(coins, n, val - coins[i]);
    // if (sub_res != Integer.MAX_VALUE)
    // res = Math.min(res, sub_res + 1);
    // }
    // }
    // return res;
    // }

    // TC : O(n*val)
    static int getMin(int[] coins, int n, int val) {
        int[] dp = new int[val + 1];
        dp[0] = 0;
        for (int i = 1; i <= val; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= val; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int sub_res = dp[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], sub_res + 1);
                }
            }
        }
        return dp[val];
    }

}
