package Dynamic_Programming;

public class CoinChangeProblem {
    public static void main(String[] args) {
        int coins[]=new int[]{2,5,3,6}; 
        int sum=4;
        System.out.println(countWays(coins, sum, coins.length));
    }

    //TC : O(2^n)
    // static int countWays(int[] coins,int n,int s){
    //     if(s==0) return 1;

    //     if(s<0) return 0;
    //     if(n==0) return 0;

    //     return countWays(coins, n, s-coins[n-1])+countWays(coins, n-1, s);
    // }

    //TC : O(n*s)
    static int countWays(int[] coins,int n,int s){
        int dp[][]=new int[n+1][s+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=1;

        for(int j=1;j<=s;j++) 
            dp[0][j]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=s;j++){
                dp[i][j]=dp[i-1][j];
                if(coins[i-1]<=j) 
                    dp[i][j]+=dp[i][j-coins[i-1]];
            }
        }
        return dp[n][s];
    }


}
