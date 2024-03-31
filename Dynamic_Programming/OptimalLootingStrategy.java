package Dynamic_Programming;

import java.util.Arrays;

public class OptimalLootingStrategy {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[] { 5, 5, 10, 100, 10, 5 };
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("Maximum value of loot selection is " + findMaxSum(arr, n, memo));
    }

    // TC : O(n)
    static int findMaxSum(int[] arr, int n, int[] memo) {
        if (n == 1)
            return arr[0];
        if (n == 2)
            return Math.max(arr[0], arr[1]);

        if (memo[n] != -1)
            return memo[n];
        return memo[n] = Math.max(findMaxSum(arr, n - 1, memo), arr[n - 1] + findMaxSum(arr, n - 2, memo));
    }
}
