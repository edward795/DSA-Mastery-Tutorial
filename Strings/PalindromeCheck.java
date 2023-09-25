package Strings;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str="mom";
        System.out.println("is the string palindrome ? "+palindrome(str));
    }

    //Naive Soln : O(n) - O(n)
    // static boolean palindrome(String str){
    //     StringBuilder rev=new StringBuilder(str);
    //     rev.reverse();
    //     return str.equals(rev);
    // }

    //Efficient Soln : O(n)
    static boolean palindrome(String str){
        int low=0,end=str.length()-1;
        while(low<=end){
            if(str.charAt(low)!=str.charAt(end))
                return false;
            low++;
            end--;
        }
        return true;
    }
}
