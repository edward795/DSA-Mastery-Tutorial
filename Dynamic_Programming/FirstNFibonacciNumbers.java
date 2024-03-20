package Dynamic_Programming;

public class FirstNFibonacciNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("The fibonacci no:s are ");
        for (Long l : printFib(n))
            System.out.print(l + " ");
    }

    // TC : O(n) -O(n)
    static long[] printFib(int n) {
        if (n == 0)
            return new long[] { 1 };
        if (n == 1)
            return new long[] { 1 };
        if (n == 2)
            return new long[] { 1 };

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp;
    }
}
