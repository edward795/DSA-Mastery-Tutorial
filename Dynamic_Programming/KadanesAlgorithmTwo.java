package Dynamic_Programming;

public class KadanesAlgorithmTwo {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 5, 6, 7, 8 };
        System.out.println("The max subarray sum excluding consecutives is : " + maximumSum(arr, arr.length - 1));
    }

    // TC : O(n)
    static long maximumSum(int[] arr, int n) {
        long[] dp = new long[n + 1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], arr[i] + dp[i - 1]), arr[i]);
        }
        return dp[n - 1];
    }
}
