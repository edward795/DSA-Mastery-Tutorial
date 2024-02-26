package Dynamic_Programming;

import java.util.Arrays;

public class Fibonacci_Series {
    
    public static void main(String[] args) {
        int n=5;
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        // System.out.println("fib series upto : "+fibonacci(n));
        System.out.println("fib series upto : "+fibonacci(n,memo));
    }

    //TC : O(2^n)
    // static int fibonacci(int n){
    //     if(n==0 || n==1) return n;

    //     return fibonacci(n-1)+fibonacci(n-2);
    // }
    
    //TC : O(n) top-down approach
    // static int fibonacci(int n,int[] memo){
    //     if(memo[n]==-1){
    //         int res;
    //         if(n==0 || n==1)
    //             res=n;
    //         else{ 
    //             res=fibonacci(n-1, memo)+fibonacci(n-2, memo);
    //             memo[n]=res;
    //         }
    //     }
    //     return memo[n];
    // }

    //TC : O(n) - O(n)
    static int fibonacci(int n,int[] memo){
        int[] fib=new int[n+1];
        fib[0]=0;
        fib[1]=1;
        for(int i=2;i<=n;i++)
            fib[i]=fib[i-1]+fib[i-2];
        return fib[n];
    }
}
