package Strings;

public class PrintFreqOfCharsLexographically{
    public static void main(String[] args) {
        int[] count=new int[26];
        String str="geeksforgeeks";

        for(int i=0;i<str.length();i++){
            count[str.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++){
            if(count[i]>0)
                System.out.print((char)(i+'a')+":"+count[i]+",");
        }
    }
}
