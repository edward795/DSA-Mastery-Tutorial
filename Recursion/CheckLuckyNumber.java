package Recursion;

public class CheckLuckyNumber {

    static int counter=2;
    public static void main(String[] args) {
        int n=13;
        System.out.println("is the number a Lucky Number:"+isLucky(n));
    }

    public static boolean isLucky(int n){
        if(counter>n) return true;

        if(n%counter==0) return false;

        int next_position=n-n/counter;
        counter++;
        return isLucky(next_position);
    }
}
