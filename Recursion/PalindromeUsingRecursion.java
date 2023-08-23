package Recursion;

public class PalindromeUsingRecursion {
    public static void main(String[] args) {
        String s="malayalam";
        System.out.println("Is string '"+s+"' palindrome? :"+isPalindrome(s,0,s.length()-1));
    }

    public static boolean isPalindrome(String s,int start,int end){
        if(start==end) return true;

        return s.charAt(start)==s.charAt(end) && isPalindrome(s,start+1,end-1);
    }
}
