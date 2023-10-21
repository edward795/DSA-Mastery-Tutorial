package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPrefixConversion {
    public static void main(String[] args) {
        String exp="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("prefix equivalent of the converted string is : "+infixToPrefix(exp));
    }

    static int prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPrefix(String exp){
        String result=new String("");
        Deque<Character> stack=new ArrayDeque<Character>();
        for(int i=exp.length()-1;i>=0;i--){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c==')')
                stack.push(c);
             else if(c=='('){
                while(!stack.isEmpty() && stack.peek()!=')'){
                    result+=stack.peek();
                    stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && prec(c)<=prec(stack.peek())){
                    result+=stack.peek();
                    stack.pop();
                }
                stack.push(c);
            } 
        }
        while(!stack.isEmpty()){
                if(stack.peek()=='('){
                    return "Invalid expression";
                }
                result+=stack.peek();
                stack.pop();
            }
        return result;
    }
}
