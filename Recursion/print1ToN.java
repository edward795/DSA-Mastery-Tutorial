package Recursion;

public class print1ToN {
    public static void main(String[] args) {
        int n=15;
        print1ToN(n);

    }

    public static void print1ToN(int n){
        if(n==0) return;
        print1ToN(n-1);
        System.out.println(n);
    }
}
