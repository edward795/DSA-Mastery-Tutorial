package Dynamic_Programming;

import java.util.Arrays;

public class MinimumNoOfJumps {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int n = arr.length;
        int[] memo = new int[n];
        // System.out.println("The min jumps are : " + minJumps(arr, n - 1, memo));
        System.out.println("The min jumps are : " + minJumps(arr, n - 1));
    }

    // TC : O(n)
    // static int minJumps(int[] arr, int n, int[] memo) {

    // if (memo[n] != -1) {
    // return memo[n];
    // } else {
    // int res = Integer.MAX_VALUE;
    // if (n == 1)
    // return 0;
    // for (int i = 0; i <= n - 2; i++) {
    // if (i + arr[i] >= n - 1) {
    // int sub_res = minJumps(arr, i + 1, memo);
    // if (sub_res != Integer.MAX_VALUE) {
    // res = Math.min(res, sub_res + 1);
    // }
    // }
    // }
    // memo[n] = res;
    // return memo[n];
    // }
    // }

    // TC : O(n)
    static int minJumps(int[] arr, int n) {
        if (n <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
                if (arr[j] == 0) {
                    continue;
                }
            }

        }
        if (dp[n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n - 1];
    }
}
