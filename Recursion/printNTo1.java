package Recursion;

public class printNTo1 {
    public static void main(String[] args) {
        int n=15;
        printNto1(n);

    }

    public static void printNto1(int n){
        if(n==0) return;
        System.out.print(n+" ");
        printNto1(n-1);
    }

}
