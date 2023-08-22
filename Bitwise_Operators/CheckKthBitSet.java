package Bitwise_Operators;
import java.util.*;

public class CheckKthBitSet {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Enter the bit pos:");
        int k=sc.nextInt();
        System.out.println("bit position is set?"+isSetBit(n,k));
    }
   
    // public static boolean isSetBit(int n,int k){
    //     if((n>>(k-1)&1)==1){
    //         return true;
    //     }else{
    //         return false;
    //     }

    // }

    public static boolean isSetBit(int n,int k){
        if((n&(1<<(k-1)))!=0){
            return true;
        }else{
            return false;
        }
    }
}
