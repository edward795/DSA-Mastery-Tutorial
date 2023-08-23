package Bitwise_Operators;

public class BinarytoGreyCodeConverter {
    public static void main(String[] args) {
        int n=7;
        System.out.println("Grey Code equivalent of "+n+" is : "+(n^(n>>1)));
    }
}
