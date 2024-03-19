package Dynamic_Programming;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[] { -9, -8, 8, 3, -4 };
        System.out.println("The max subarray value is " + maximumSum(arr, arr.length));
    }

    // TC : O(n)
    static long maximumSum(int[] arr, int n) {
        long[] dp = new long[n + 1];
        long res = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            res = Math.max(res, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(dp[i] + " ");
        }
        System.out.println();
        return res;
    }
}
