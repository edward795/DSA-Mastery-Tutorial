package Bitwise_Operators;

public class FindPosRightMostSetBit {
    public static void main(String[] args) {
        int n=8;
        System.out.println("Position of rightmost set bit: "+posRightMostBit(n));
    }

    public static int posRightMostBit(int n){
        return (int)(Math.log10(n&(-n))/Math.log10(2)+1);
    }
}
