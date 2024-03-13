package Dynamic_Programming;

public class MaxConsecutiveSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 5, 15, 20, 2, 30 };
        int n = arr.length;
        System.out.println("The max sum of consecutive elements : " + maxConsecutive(arr, n));
    }

    // TC : O(2^n) - recursive
    // static int maxConsecutive(int[] arr, int n) {
    // if (n == 1)
    // return arr[0];
    // else if (n == 2)
    // return Math.max(arr[0], arr[1]);
    // else
    // return Math.max(maxConsecutive(arr, n - 1), arr[n - 1] + maxConsecutive(arr,
    // n - 2));
    // }

    // TC : O(n) - O(n) - dp based soln
    // static int maxConsecutive(int[] arr, int n) {
    // int[] dp = new int[n + 1];
    // dp[1] = arr[0];
    // dp[2] = Math.max(arr[0], arr[1]);
    // for (int i = 3; i <= n; i++)
    // dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
    // return dp[n];
    // }

    // TC : O(n) - O(1) - fibonacci approach
    static int maxConsecutive(int[] arr, int n) {
        if (n == 1)
            return arr[0];
        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;
        for (int i = 3; i <= n; i++) {
            res = Math.max(prev, prev_prev + arr[i - 1]);
            prev_prev = prev;
            prev = res;
        }
        return res;
    }
}
