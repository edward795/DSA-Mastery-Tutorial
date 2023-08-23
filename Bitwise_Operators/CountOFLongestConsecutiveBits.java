package Bitwise_Operators;

public class CountOFLongestConsecutiveBits {
    public static void main(String[] args) {
        int n=10;
        System.out.println("Count of longest consecutive bits:"+longestConsecutiveBits(n));
    }
    
    //O(n)
    public static int longestConsecutiveBits(int n){
        int count=0;
        while(n>0){
            n=n&(n<<1);
            count++;
        }
        return count;
    }
}
