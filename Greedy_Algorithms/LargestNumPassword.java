package Greedy_Algorithms;

public class LargestNumPassword {
    public static void main(String[] args) {
        int n=5,s=12;
        System.out.println(largestNumber(n, s));
    }

    static String largestNumber(int n,int sum){
        if(n*9<sum){
            return "-1";
        }

        String ans=" ";
        for(int i=0;i<n;i++){
            int num=0;
            if(sum>9){
                num=9;
                sum-=9;
            }else{
                num=sum;
                sum=0;
            }
            ans+=(num);
        }
        return ans;
    }
}
