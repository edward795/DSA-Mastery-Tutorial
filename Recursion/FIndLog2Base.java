package Recursion;

public class FIndLog2Base {
    public static void main(String[] args) {
        int n=16;
        System.out.println("Log 2 to the base value of a number:"+log2Base(n));
    }
    
    //Note - only positive numbers are allowed
    //Time Complexity - O(n)
    public static int log2Base(int n){
        if(n==1) return 0;
        else return 1+log2Base(n/2);

    }
}
