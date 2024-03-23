package Dynamic_Programming;

public class LcsRecursive {
    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        System.out.println("The longest common subsequence is : " + lcs(S1, S2, S1.length() - 1, S2.length() - 1));
    }

    // TC : O(2^n)
    // static int lcs(String s1, String s2, int m, int n) {
    // if (m == 0 || n == 0)
    // return 0;

    // if (s1.charAt(m - 1) == s2.charAt(n - 1))
    // return 1 + lcs(s1, s2, m - 1, n - 1);
    // else
    // return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    // }

    // TC : O(m*n)
    static int lcs(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 0;

        for (int j = 0; j < n; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}