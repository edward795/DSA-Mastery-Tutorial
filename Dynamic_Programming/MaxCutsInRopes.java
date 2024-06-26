package Dynamic_Programming;

public class MaxCutsInRopes {
    public static void main(String[] args) {
        int n = 5, a = 1, b = 2, c = 3;
        System.out.println("The max value of cuts is : "+maxCuts(n, a, b, c));
    }

    //TC : O(2^n)
    // static int maxCuts(int n, int a, int b, int c) {
    //     if (n < 0)
    //         return -1;
    //     if (n == 0)
    //         return 0;
    //     int res = Math.max(Math.max(maxCuts(n - a, a, b, c), maxCuts(n - b, a, b, c)), maxCuts(n - c, a, b, c));
    //     if(res==-1) 
    //         return res;
    //     return res+1;
    // }

    //TC : O(n) - O(n)
    static int maxCuts(int n,int a,int b,int c){
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=-1;
            if(i-a>=0) dp[i]=Math.max(dp[i],dp[i-a]);
            if(i-b>=0) dp[i]=Math.max(dp[i],dp[i-b]);
            if(i-c>=0) dp[i]=Math.max(dp[i],dp[i-c]);

            if(dp[i]!=-1) dp[i]++;
        }
        return dp[n];
    }
}
