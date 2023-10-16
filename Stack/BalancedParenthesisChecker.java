package Stack;

import java.util.ArrayDeque;

public class BalancedParenthesisChecker {
    public static void main(String[] args) {
        String str="([])";
        System.out.println("Is the string balanced parenthesis ? "+isBalanced(str));
    }

    static boolean isBalanced(String str){
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='[' || ch=='}')
                st.push(ch);
            else{
                 if(st.isEmpty())
                    return false;
                 else if(isMatching(st.peek(),ch)==false)
                    return false;
                 else 
                    st.pop();
            }
        }
        return st.isEmpty();
    }

    static boolean isMatching(char a,char b){
        return ((a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}'));
    }
}
