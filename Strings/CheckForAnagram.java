package Strings;

import java.util.Arrays;

public class CheckForAnagram {
    public static void main(String[] args) {
        String s1="listen";
        String s2="silent";
        System.out.println("Are the 2 strings Anagram ? "+isAnagram(s1, s2));
    }

    //Naive Soln :O(nlogn)
    // static boolean isAnagram(String s1,String s2){
    //     if(s1.length()!=s2.length()) return false;

    //     char[] str1=s1.toCharArray();
    //     char[] str2=s2.toCharArray();

    //     Arrays.sort(str1);
    //     Arrays.sort(str2);


    //     for(int i=0;i<s1.length();i++){
    //         if(str1[i]!=str2[i])
    //             return false;
    //     }
    //     return true;
    // }

    //Efficient Soln :O(n) -O(n)
    static boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;

        int[] count=new int[256];

        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for(int i=0;i<s1.length();i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}
