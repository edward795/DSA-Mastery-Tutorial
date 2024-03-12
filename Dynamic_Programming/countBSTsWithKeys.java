package Dynamic_Programming;

public class countBSTsWithKeys {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("The count of BSTs with keys : " + countBSTSsKeys(n));
    }

    // TC : O(2^n) - recursive soln
    // static int countBSTSsKeys(int n) {
    // if (n == 1 || n == 0)
    // return 1;

    // int res = 0, countLeft = 0, countRight = 0;
    // for (int i = 0; i < n; i++) {
    // countLeft = countBSTSsKeys(i);
    // countRight = countBSTSsKeys(n - i - 1);
    // res = res + countLeft * countRight;
    // }
    // return res;
    // }

    // TC : O(n)
    static int countBSTSsKeys(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
