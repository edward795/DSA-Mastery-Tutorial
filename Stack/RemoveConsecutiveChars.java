package Stack;

import java.util.Stack;

public class RemoveConsecutiveChars {
    public static void main(String[] args) {
        String res="aaaaaabaabcccccc";
        System.out.println("Removed Duplicates:"+removeDups(res));
    }

    static String removeDups(String str){
        int n=str.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || st.peek()!=str.charAt(i)){
                st.push(str.charAt(i));
            }
        }

        String res="";
        for(Character ch:st){
            res=ch+res;
        }
        return res;
    }
}
