package Bitwise_Operators;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n=9;
        System.out.println("The no: "+n+" is a power of 2?: "+isPowerOfTwo(n));
    }
    //Naive soln - O(n)
    // public static boolean isPowerOfTwo(int n){
    //     if(n==0) return false;
        
    //     while(n!=1){
    //         if(n%2!=0) return false;
    //         n=n/2;
    //     }
    //     return true;
    // }
    
    //Efficient soln: O(1) - Brian Kerningam Algorithm - Note:powers of 2 has only 1 set bit
    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }
}
