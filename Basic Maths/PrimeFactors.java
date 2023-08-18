import java.util.*;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Prime Factors are:");
        getPrimeFactors(n);
    }

     //Naive Soln
    // public static boolean isPrime(int n){
    //     if(n==1) return false;
    //     for(int i=2;i*i<n;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
    // }

    // public static void getPrimeFactors(int n){
    //     for(int i=2;i<n;i++){
    //         if(isPrime(i)){
    //            int x=i;
    //            while(n%x==0){
    //               System.out.print(i+" ");
    //               x=x*i;
    //            }
    //         }
    //     }
    // }

    //Efficient Soln
    // public static void getPrimeFactors(int n){
    //     if(n<=1) return;
    //     for(int i=2;i*i<=n;i++){
    //         while(n%i==0){
    //             System.out.print(i+" ");
    //             n=n/i;
    //         }
    //         // if(n>1) 
    //         //     System.out.print(" "+n);
    //     }
    // }

     public static void getPrimeFactors(int n){
        int i;
        for(i=2;i*i<=n;i++){
            if(n%i==0) System.out.println(i);
        }

        for(;i*i>=1;i--){
            if(n%i==0) System.out.println(n%i);
        }
     }

    //Best Soln 
    // public static void getPrimeFactors(int n){
    //     if(n<=1) return;
    //     while(n%2==0){
    //         System.out.println(2);
    //         n=n/2;
    //     }

    //     while(n%3==0){
    //         System.out.println(3);
    //         n=n/3;
    //     }

    //     for(int i=5;i*i<=n;i+=6){
    //         while(n%i==0){
    //             System.out.println(i);
    //             n=n/i;
    //         }


    //         while(n%(i+2)==0){
    //             System.out.println(i+2);
    //             n=n/(i+2);
    //         }
    //     }

    //     if(n>3) System.out.println(n);
    // }

}
