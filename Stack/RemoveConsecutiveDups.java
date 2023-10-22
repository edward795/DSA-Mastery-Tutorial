package Stack;

import java.util.Stack;

public class RemoveConsecutiveDups {
    public static void main(String[] args) {
        String str="aaabbaaccd";
        System.out.println("After removing duplicates:"+removeDups(str));
    }

    static String removeDups(String str){
        int n=str.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(!st.isEmpty() || st.peek()==str.charAt(i)){
                st.pop();
            }else{
                st.push(str.charAt(i));
            }
        }

        String res="";
        while(!st.isEmpty()) 
            res+=st.pop();

        return res;
    }
}
