package Bitwise_Operators;

public class CheckForSparseNumber {
    public static void main(String[] args) {
        int n=3;
        //a no: is sparse if 2 or more of its consecutive bits are set
        System.out.println("If the number is sparse or not?:"+((n&(n>>1))==0));
    }
}
