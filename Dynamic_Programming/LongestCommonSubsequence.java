package Dynamic_Programming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1="ABCDGH";
        String s2="AEDFHR";
        System.out.println("Longest Common Subsequence of "+s1+" "+s2+" "+"is ");
        // int[][] memo=new int[s1.length()][s2.length()];
        // System.out.println(lcs(s1, s2, s1.length(), s2.length(),memo));
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
    }

    //TC : O(2^n) - recursive soln
    // static int lcs(String s1,String s2,int m,int n){
    //     if(m==0 || n==0){
    //         return 0;
    //     }
    //     if(s1.charAt(m-1)==s2.charAt(n-1))
    //         return 1+lcs(s1,s2,m-1,n-1);
    //     return Math.max(lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
    // }

    //TC : O(mn) - memoized soln
    // static int lcs(String s1,String s2,int m,int n,int[][] memo){
    //     if(memo[m][n]==-1){
    //         return memo[m][n];
    //     }

    //     if(m==0 || n==0){
    //         memo[m][n]=0;
    //     }else{
    //         if(s1.charAt(m-1)==s2.charAt(n-1))
    //             memo[m][n]=1+lcs(s1,s2,m-1,n-1,memo);
    //         else 
    //             memo[m][n]=Math.max(lcs(s1,s2,m-1,n,memo),lcs(s1,s2,m,n-1,memo));
    //     }
    //     return memo[m][n];
    // }

    //TC : O(mn) - dp based soln
    static int lcs(String s1,String s2,int m,int n){
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0]=0;
        for(int j=0;j<=n;j++) 
            dp[0][j]=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else 
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}
