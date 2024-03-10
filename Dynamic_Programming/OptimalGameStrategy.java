package Dynamic_Programming;

public class OptimalGameStrategy {
    public static void main(String[] args) {
        int[] arr = new int[] { 20, 5, 4, 6 };
        int n = arr.length;
        // System.out.println("The sum of winner's picks : " + sol(arr, 0, n - 1, 0));
        System.out.println("The sum of winner's picks : " + sol(arr, n - 1));
    }

    // TC :O(2^n) - recursive soln
    // static int sol(int[] arr, int i, int j, int sum) {
    // if (j == i + 1)
    // return Math.max(arr[i], arr[j]);

    // return Math.max(sum - sol(arr, i, j - 1, sum - arr[j]), sum - sol(arr, i + 1,
    // j, sum - arr[i]));
    // }

    // TC : O(2^n) - recursive soln
    // static int sol(int[] arr, int i, int j, int sum) {
    // if (j == i + 1)
    // return Math.max(arr[i], arr[j]);

    // return Math.max(arr[i] + Math.min(sol(arr, i + 1, j - 1, sum - arr[i]),
    // sol(arr, i + 2, j, sum - arr[i])),
    // arr[j] + Math.min(sol(arr, i + 1, j - 1, sum - arr[j]), sol(arr, i, j - 2,
    // sum - arr[j])));
    // }

    // TC : O(n*m)
    static int sol(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);

        for (int gap = 3; gap < n; gap = gap + 2) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        return dp[0][n - 1];
    }
}