package Strings;

public class IsRotatedString {
    public static void main(String[] args) {
        String s1="ABCD",s2="CDAB";
        System.out.println("Are the strings rotations? :"+isRotated(s1, s2));
    }

    //TC : O(n)
    static boolean isRotated(String str1,String str2){
        if(str1.length()!=str2.length()) return false;
        return (str1+str2).indexOf(str2)>=0;
    }
}
