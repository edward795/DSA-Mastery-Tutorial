import java.util.*;
public class TrailingZeroesFactorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=sc.nextInt();
        //Naive Solution : probably won't even run in ur local machine for an input->100.
        // long fact=factorial(n);
        // System.out.println("Trailing zeroes:"+getTrailingZeroes(fact));

        //Efficient Soln
        System.out.println("Trailing zeroes:"+countTrailingZeroes(n));

    }
    
    
    // public static long factorial(int n){
    //     long fact=1;
    //     for(int i=1;i<=n;i++){
    //         fact=fact*i;
    //     }
    //     return fact;
    // }

    // public static int getTrailingZeroes(long fact){
    //     int count=0;
    //     while(fact%10==0){
    //         count++;
    //         fact/=10;
    //     }
    //     return count;
    // }

    public static int countTrailingZeroes(int n){
        int count=0; 
        for(int i=5;i<=n;i*=5){
            count+=n/i;
        }
        return count;
    }
    
}
