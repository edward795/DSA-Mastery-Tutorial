package Dynamic_Programming;

public class SumOfSubstrings {
    public static void main(String[] args) {
        String str = "1234";
        System.out.println("The sum of all substrings is " + sumSubStrings(str));
    }

    // public static long sumSubStrings(String s) {
    // int n = s.length();
    // int[] sum = new int[n];
    // sum[0] = s.charAt(0) - '0';
    // int res = sum[0];
    // int mod = 1000000007;
    // for (int i = 1; i < n; i++) {
    // int numi = s.charAt(i) - '0';
    // sum[i] = (((i + 1) * numi) % mod + (10 * sum[i - 1]) % mod) % mod;
    // res += sum[i];
    // }
    // return res;
    // }

    // TC : O(n)
    public static long sumSubStrings(String s) {
        long[] sum = new long[s.length()];
        long a = Character.getNumericValue(s.charAt(0));
        sum[0] = a;
        long result = sum[0];
        int mod = 1000000007;
        for (int i = 1; i < s.length(); i++) {
            long k = Character.getNumericValue(s.charAt(i));
            sum[i] = ((i + 1) * k + (10 * sum[i - 1])) % mod;
            result += sum[i] % mod;
        }
        return result % mod;
    }
}