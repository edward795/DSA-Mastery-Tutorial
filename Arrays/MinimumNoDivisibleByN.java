package Arrays;

/**
 * Given a number n;Find a number which is divisible by all no:s upto n a.ka LCM of all numbes upto n
 * domodular of 10^9 + 7
 */
public class MinimumNoDivisibleByN {
    public static void main(String[] args) {
        int n=3;
        System.out.println("Number Divisibe By n is : "+getLCMRange(n));
    }
    static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }

    static int getLCMRange(int n){
        int res=1;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=2;i<n+1;i++){
            res=(res*i)/gcd(res,i);
        }
        return res%mod;
    }
}
