package Dynamic_Programming;

import java.math.BigInteger;

public class NthCatalanNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("The nth catalan no: is " + findCatalan(n));
    }

    // TC : O(2^n)
    static int findCatalan(int n) {
        int res = 0;
        if (n <= 1)
            return 1;

        for (int i = 0; i < n; i++) {
            res += findCatalan(i) * findCatalan(n - i - 1);
        }
        return res;
    }

    // TC : O(n) dp based approach
    // static BigInteger findCatalan(int n) {
    // BigInteger[] dp = new BigInteger[n + 1];
    // dp[0] = BigInteger.valueOf(1);
    // dp[1] = BigInteger.valueOf(1);
    // for (int i = 2; i <= n; i++) {
    // dp[i] = BigInteger.valueOf(0);
    // for (int j = 0; j < i; j++) {
    // dp[i] = dp[i].add(dp[i - j - 1].multiply(dp[j]));
    // }
    // }
    // return dp[n];
    // }
}
