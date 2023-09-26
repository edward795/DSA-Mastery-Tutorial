package Strings;

import java.util.Stack;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String str="Apple is a fruit";
        System.out.println("After reversing : ");
        System.out.println(reverseWords(str));
    }
    //Naive Solution 1 - O(n) -O(n)
    // static String reverseWords(String str){
    //     Stack<String> st=new Stack<>();
    //     String res="";
    //     int start=0;
    //     for(int i=0;i<str.length();i++){
    //         if(str.charAt(i)==' '){
    //             st.push(str.substring(start, i+1));
    //             start=i+1;
    //         }
    //     }
    //     st.push(str.substring(start,str.length()));

    //     while(!st.isEmpty()){
    //         res=res+st.pop();
    //         res=res+" ";
    //     }
    //     return res;
    // }
    
    //Naive Soln 2 :O(n) - O(n)
    // static String reverseWords(String str){
    //     Stack<String> st=new Stack<>();
    //     String res="";
    //     String[] arr=str.split(" ");
    //     for(int i=0;i<arr.length;i++){
    //         st.push(arr[i]);
    //     }
    //     while(!st.isEmpty()){
    //         res+=st.pop();
    //         res+=" ";
    //     }
    //     return res;
    // }

    //Efficient Soln : O(n) -O(1)
    static String reverseWords(String str){
        int start=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str=reverse(str,start,i);
                start=i+1;
            }
        }
        str=reverse(str,start,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }

    static String reverse(String str,int low,int high){
        char[] chars=str.toCharArray();
        while(low<=high){
            char temp=chars[low];
            chars[low]=chars[high];
            chars[high]=temp;
            low++;
            high--;
        }
        return new String(chars);
    }
}
