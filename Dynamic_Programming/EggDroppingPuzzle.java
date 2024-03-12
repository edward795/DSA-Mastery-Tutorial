package Dynamic_Programming;

public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int e = 2, f = 10;
        System.out.println("Minimum no of trials in worst case : " + eggDrops(e, f));
    }

    // TC : O(2^n)
    // static int eggDrops(int e, int f) {
    // if (f == 1 || f == 0)
    // return f;

    // if (e == 1)
    // return f;
    // int min = Integer.MAX_VALUE;
    // int res, x;
    // for (x = 1; x <= f; x++) {
    // res = Math.max(eggDrops(e - 1, x - 1), eggDrops(e, f - x));
    // if (res < min)
    // min = res;
    // }

    // return min + 1;
    // }

    // TC : O((f^2)*e)
    static int eggDrops(int e, int f) {
        int dp[][] = new int[f + 1][e + 1];
        for (int i = 1; i <= e; i++) {
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        for (int j = 1; j <= f; j++) {
            dp[j][1] = j;
        }

        for (int i = 2; i <= f; i++) {
            for (int j = 2; j <= e; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= i; x++)
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
            }
        }
        return dp[f][e];
    }
}