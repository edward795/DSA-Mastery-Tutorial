import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        System.out.println("Is Prime:"+isPrime(n));
    }
    //Naive Soln
    // public static boolean isPrime(int n){
    //     if(n==1) return false;
    //     for(int i=2;i<n;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
    // }

    //Efficient Solution
    // public static boolean isPrime(int n){
    //     if(n==1) return false;
    //     for(int i=2;i*i<n;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
    // }

    //Best Solution - for large values of n
    public static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2 || n==3) return true;

        if(n%2==0 || n%3==0) return false;

        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
