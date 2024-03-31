package Dynamic_Programming;

public class NoOfBinarySearchTrees {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("No of possible binaruy search trees (nth Catalan number) : " + numTrees(n));
    }

    // TC : O(n^2)
    static int numTrees(int n) {
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] % mod + dp[j] % mod * dp[i - j - 1] % mod) % mod;
            }
        }
        return (int) dp[n];
    }
}
