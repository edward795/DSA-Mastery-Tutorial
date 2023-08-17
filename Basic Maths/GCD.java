import java.util.*;
public class GCD {
    public static void main(String[] args) {
        int a=10,b=15;
        System.out.println("gcd of "+a+" and "+b+" : "+gcd(a,b));
    }
    //Naive soln
    // public static int gcd(int a,int b){
    //     int res=Math.min(a,b);
    //     while(res>0){
    //         if(a%res==0 && b%res==0){
    //             break;
    //         }
    //         res--;
    //     }
    //     return res;
    // }

    //better soln 
    // public static int gcd(int a,int b){
    //     while(a!=b){
    //         if(a>b){
    //             a=a-b;
    //         }else{
    //             b=b-a;
    //         }
    //     }

    //     return a;
    // }

    //best soln : Eucledian Algorithm
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
