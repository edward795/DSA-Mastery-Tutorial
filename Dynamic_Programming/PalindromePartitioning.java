package Dynamic_Programming;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "abcde";
        // System.out.println("Max palindrome partitioned value of String is " +
        // palindromePart(str, 0, str.length() - 1));
        System.out.println("Max palindrome partitioned value of String is " + palindromePart(str));
    }

    // TC : O(2^n)
    // static int palindromePart(String s, int i, int j) {
    // if (isPalindrome(s, i, j))
    // return 0;

    // int res = Integer.MAX_VALUE;
    // for (int k = i; k < j; k++) {
    // res = Math.min(res, 1 + palindromePart(s, i, k) + palindromePart(s, k + 1,
    // j));
    // }
    // return res;
    // }

    // TC : O(n^3) - O(n^2)
    static int palindromePart(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 0;

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (isPalindrome(s, i, j))
                    dp[i][j] = 0;
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++)
                        dp[i][j] = Math.min(dp[i][j], 1 + dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
        }
        return true;
    }
}
