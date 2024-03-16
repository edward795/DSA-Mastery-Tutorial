package Dynamic_Programming;

public class MatrixChainMultiplication {
    public static void main(String[] args) {

        int[] arr = new int[] { 2, 1, 3 };
        System.out.println("The min count value of array is " + minCountOfMultiplicatiions(arr, arr.length - 1));

    }

    // TC : O(3^n) - O(1)
    // static int minCountOfMultiplicatiions(int[] arr, int i, int j) {
    // if (i + 1 == j)
    // return 0;

    // int res = Integer.MAX_VALUE;
    // for (int k = i + 1; k < j; k++) {
    // res = Math.min(res, minCountOfMultiplicatiions(arr, i, k) +
    // minCountOfMultiplicatiions(arr, k, j)
    // + arr[i] * arr[k] * arr[j]);
    // }
    // return res;
    // }

    // TC : O(n^3) - O(n^2)
    static int minCountOfMultiplicatiions(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = 0;

        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[j][k] + arr[i] * arr[j] * arr[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
