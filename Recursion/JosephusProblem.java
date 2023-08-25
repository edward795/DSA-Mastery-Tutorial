package Recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        int n=7,k=3;
        System.out.println("Position of last remaining person:"+jos(n, k));

    }
    
    //TC : O(n)
    public static int jos(int n,int k){
        if(n==1) return 0;
        else{
            return (jos(n-1,k)+k)%n+1;
        }
    }
}
