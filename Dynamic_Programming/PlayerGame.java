package Dynamic_Programming;

public class PlayerGame {
    public static void main(String[] args) {
        int[] coins = new int[] { 3, 5, 10 };
        int n = 8;
        System.out.println("The counts of combinations to reach n=8 " + countWays(coins, coins.length, n));
    }

    // TC : O(n)
    static int countWays(int[] coins, int n, int s) {
        if (s == 0)
            return 1;
        if (n == 0)
            return 0;

        if (s < 0)
            return 0;

        return countWays(coins, n, s - coins[n - 1]) + countWays(coins, n - 1, s);
    }
}
