package Dynamic_Programming;

public class MinJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = new int[] { 4, 1, 5, 3, 1, 3, 2, 1, 8 };
        System.out.println("The min jumps required is " + minJumps(arr, arr.length));
    }

    // TC : O(2^n) - recursion based
    // static int minJumps(int[] arr, int n) {
    // if (n == 1)
    // return 0;
    // int res = Integer.MAX_VALUE;
    // for (int i = 0; i <= n - 2; i++) {
    // if (i + arr[i] >= n - 1) {
    // int sub_res = minJumps(arr, i + 1);
    // if (sub_res != Integer.MAX_VALUE)
    // res = Math.min(res, sub_res + 1);
    // }
    // }
    // return res;
    // }

    // TC : O(n*n)
    static int minJumps(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
