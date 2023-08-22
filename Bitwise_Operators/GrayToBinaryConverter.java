package Bitwise_Operators;

public class GrayToBinaryConverter {
    public static void main(String[] args) {
        int n=4;
        System.out.println("Gray Code equivalent of the number "+n+" is:"+GrayToBinaryCodeConverter(n));
    }

    public static int GrayToBinaryCodeConverter(int n){
        int res=n;
        while(n>0){
            n=n>>1;
            res=res^n;
        }
        return res;
    }
}
