import java.util.*;

public class CountDigits{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number:");
        int n=sc.nextInt();
        int count=0;
        while(n-->0){
            count++;
            n/=10;
        }
        System.out.println("Count Of Digits12:"+count);
    }
}