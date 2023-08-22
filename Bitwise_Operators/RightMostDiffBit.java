package Bitwise_Operators;

public class RightMostDiffBit {
    public static void main(String[] args) {
        int n=52,m=24;
        System.out.println("Right Most different bit is:"+rightMostDiffBit(n^m));
    }
    
    //Bitwise approach - O(1)
    public static int rightMostDiffBit(int n){
        return (int)(Math.log10(n&-n)/Math.log10(2))+1;
    }
}
