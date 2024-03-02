package Dynamic_Programming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "cat", s2 = "cut";
        int n = s1.length(), m = s2.length();
        // System.out.println("Min no operations req to make s1 as s2 : "+CD(s1, s2, m,
        // n));
        // int[][] memo = new int[m + 1][n + 1];
        // for (int i = 0; i < m + 1; i++) {
        //     Arrays.fill(memo[i], -1);
        // }
        // System.out.println("Min no operations req to make s1 as s2 : " + CDMemoized(s1, s2, m, n, memo));

        System.out.println("Min no operations req to make s1 as s2 : "+CDBottomUp(s1, s2, m, n));
    }

    // TC : O(2^n) - Recursive Soln
    // static int CD(String s1,String s2,int m,int n){
    // if(m==0) return n;
    // if(n==0) return m;

    // if(s1.charAt(m-1)==s2.charAt(n-1)){
    // return CD(s1,s2,m-1,n-1);
    // }else{
    // return 1+Math.min(Math.min(CD(s1,s2,m-1,n),CD(s1,s2,m,n-1)),CD(s1, s2, m-1,
    // n-1));
    // }
    // }

    //TC : O(m*n) - memoized soln
    // static int CDMemoized(String s1, String s2, int m, int n, int[][] memo) {
    //     if (memo[m][n] != -1) {
    //         return memo[m][n];
    //     } else {
    //         if (m == 0)
    //             return n;
    //         if (n == 0)
    //             return m;

    //         if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
    //             memo[n - 1][m - 1] = CDMemoized(s1, s2, m - 1, n - 1, memo);
    //         } else {
    //             memo[m - 1][n - 1] = 1
    //                     + Math.min(Math.min(CDMemoized(s1, s2, m - 1, n, memo), CDMemoized(s1, s2, m, n - 1, memo)),
    //                             CDMemoized(s1, s2, m - 1, n - 1, memo));
    //         }

    //         return memo[m][n];
    //     }
    // }

    //TC : O(m*n) - Bottom Up approach
    static int CDBottomUp(String s1,String s2,int m,int n){
        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++)
            dp[i][0]=i;

        for(int j=0;j<=n;j++) 
            dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

}
