package Bitwise_Operators;

public class SwapOddEvenBits {
    public static void main(String[] args) {
        int n = 43;
        System.out.println("Swapped Number is:" + swapEvenOddBits(n));

    }

    //0xAAAAAAAA is used to extract even numbers & 0x55555555 is used to extract odd numbers out of a given number.
    //Time Complexity - O(1)
    public static int swapEvenOddBits(int n) {
        int even = n & (0xAAAAAAAA);
        int odd = n & (0x55555555);
        int e = even >> 1;
        int o = odd << 1;
        return e ^ o;
    }
}