package Dynamic_Programming;

public class LongestCommonSuperSeq {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "xycd";
        System.out.println(
                "The longest common supersequence is " + shortestCommonSuperSeq(s1, s2, s1.length(), s2.length()));
    }

    // TC : O(2^n)
    // static int shortestCommonSuperSeq(String s1, String s2, int m, int n) {
    // return (m + n) - lcs(s1, s2, m, n);
    // }

    // static int lcs(String s1, String s2, int m, int n) {
    // if (m == 0 || n == 0)
    // return 0;

    // if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
    // return 1 + lcs(s1, s2, m - 1, n - 1);
    // } else {
    // return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    // }
    // }

    // TC : O(m*n)
    static int shortestCommonSuperSeq(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;

        for (int j = 0; j <= n; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (m + n) - dp[m][n];
    }
}
