package Dynamic_Programming;

public class NumberOfUniquePaths {
    public static void main(String[] args) {
        int A = 3, B = 4;
        System.out.println("The no: of paths " + numberOfPaths(A, B));
    }

    // TC : O(A*B)
    static int numberOfPaths(int a, int b) {
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[a - 1][b - 1];
    }
}
