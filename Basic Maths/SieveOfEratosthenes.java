import java.util.*;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number:");
        int n=sc.nextInt();
        System.out.println("The Prime numbers are:");
        getPrimeNumbers(n);
    }


    //Naive Solution - O(n*√n)
    // public static void getPrimeNumbers(int n){
    //     for(int i=2;i<n;i++){
    //         if(isPrime(i)){
    //             System.out.println(i);
    //         }
    //     }
    // }

    // public static boolean isPrime(int n){
    //     if(n<=1) return false;
    //     for(int i=2;i<n;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
    // }

    //Optimized Solution - Sieve Of Eratosthenes Algorithm - O(n*loglog(n)) - 0(n)
    public static void getPrimeNumbers(int n){
        boolean isPrime[]=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=2*i;j<=n;j=j+i){ //you can give i*i as well
                    isPrime[j]=false;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }
}
