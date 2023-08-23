package Recursion;

public class DecimalToBinaryConversion {
    public static void main(String[] args) {
        int n=12;
        System.out.println("Binary of the number "+n+" is : ");
        binaryConverter(n);
    }
    

    //Recursive method 1
    // public static int binaryConverter(int n){
    //     if(n==0) return 0;
        
    //     return n%2+10*binaryConverter(n/2);
    // }

    //Recursive method 2
    public static void binaryConverter(int n){
        if(n==0) return;

        binaryConverter(n/2);
        System.out.print(n%2);
    }

}
