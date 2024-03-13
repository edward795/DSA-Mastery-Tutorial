package Dynamic_Programming;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 5, 2, 3, 6 };
        int sum = 8;
        System.out.println("Subsets with sum 8 are : " + subsetSum(arr, arr.length, sum));
    }

    // TC : O(2^n)
    // static int subsetSum(int[] arr, int n, int sum) {
    // if (n == 0)
    // return (sum == 0) ? 1 : 0;
    // return subsetSum(arr, n - 1, sum) + subsetSum(arr, n - 1, sum - arr[n - 1]);
    // }

    // TC : O(n*sum)
    static int subsetSum(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 0; j <= sum; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
            }
        }
        return dp[n - 1][sum - 1];
    }
}
