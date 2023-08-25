package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n=3;
        System.out.println("The no of movements required:"+toh(n, 'A', 'C', 'B'));
    }
    
    //TC:O(2^n)
    public static int toh(int n,char from_rod,char to_rod,char aux_rod){
        if(n==0){
            return 0;
        }
        toh(n-1,from_rod,aux_rod,to_rod);
        System.out.println("Disk "+n+" moved from rod "+from_rod+" to rod "+to_rod);
        toh(n-1,aux_rod,to_rod,from_rod);
        return (int)(Math.pow(2,n)-1);
    }
}
