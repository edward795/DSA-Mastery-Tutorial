package Bitwise_Operators;

public class PowerSetUsingBitwiseOperators{
    public static void main(String[] args) {
        String s="abc";
        System.out.println("Power Set Of Characters using bitwise operators:");
        powerSet(s);
    }
    
    //BtWise Soln - O(2ᴺ*N)
    public static void powerSet(String s){
        int p=(int) Math.pow(2,s.length());
        int n=s.length();
        for(int i=0;i<p;i++){
            for(int j=0;j<n;j++){
                if((i&(1<<j))!=0){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}