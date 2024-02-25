package Backtracking;

public class BlackAndWhite {
    public static void main(String[] args) {
        int n=2,m=2;
        System.out.println("total no of ways : "+numOfWays(n, m));
    }

    static long numOfWays(int n,int m){
        int dx[]={-2,-1,1,2};
        int dy[]={1,2,2,1};
        long ret=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    int xn=i+dx[k];
                    int yn=j+dy[k];

                    if(xn>=0 && xn<m && yn>=0 && yn<m) ret++;
                }
            }
        }
        long mod=1000000007;
        long tot=(m*n)%mod;
        tot=tot*(tot-1)/2;

        return 2*(tot-ret)%mod;
    }
}
