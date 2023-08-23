package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int n=245;
        System.out.println("Sum of Digits of "+n+":"+SumOfDigits(n));
    }

    public static int SumOfDigits(int n){
        if(n==0) return 0;
        return n%10+SumOfDigits(n/10);
    }
}
