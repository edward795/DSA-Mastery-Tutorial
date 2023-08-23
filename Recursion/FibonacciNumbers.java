package Recursion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int n=5;
        System.out.println(n+"th term in fibonacci is:"+fibonacci(n));
    }
    
    //Recursive : O(n) 
    public static int fibonacci(int n){
        if(n==0 || n==1) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }
}
