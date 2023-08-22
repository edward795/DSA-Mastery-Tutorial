package Bitwise_Operators;
import java.util.*;

public class CountSetBits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Count Of Set Bits:"+countSetBits(n));
    }
     //Naive Soln - O(n)
    // public static int countSetBits(int n){
    //     int count=0;
    //     while(n>0){
    //         if(n%2!=0){
    //             count++;
    //         }
    //         n=n/2;
    //     }
    //     return count;
    // }
    
    //Efficient Soln - O(n)
    // public static int countSetBits(int n){
    //     int count=0;
    //     while(n>0){
    //         if((n&1)==1)
    //             count++;
    //         n=n>>1;
    //     }
    //     return count;
    // }
    
    //More Efficient Soln - O(set bits)
    // public static int countSetBits(int n){
    //     int count=0;
    //     while(n>0){
    //         n=(n&(n-1));
    //         count++;
    //     }
    //     return count;
    // }

    //Best Soln - Look Up Table based - O(1)
    public static int countSetBits(int n){
        int table[]=new int[256];
        table[0]=0;
        for(int i=1;i<256;i++){
            table[i]=(i&1)+table[i/2];
        }
        int res=table[n&0xff];
        n=n>>8;
        res+=table[n&0xff];
        n=n>>8;
        res+=table[n&0xff];
        n=n>>8;
        res+=table[n&0xff];
        n=n>>8;
        return res;
    }

}
