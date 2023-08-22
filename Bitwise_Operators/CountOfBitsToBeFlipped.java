package Bitwise_Operators;
//Program to count the bits to be flipped so that the 1st no can be made equal to the 2nd number
public class CountOfBitsToBeFlipped {
    public static void main(String[] args) {
        int a=10,b=20;
        System.out.println("The count of bits to be flipped:"+countOfBitsToBeFlipped(a, b));
    }
    
    //Time Complexity - O(n)
    public static int countOfBitsToBeFlipped(int a,int b){
        int res=a^b;
        int count=0;
        while(res>0){
            res=res&(res-1);
            count++;
        }
        return count;
    }
}
