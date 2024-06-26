package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfixConversion {
    public static void main(String[] args) {
        String exp="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("postfix equivalent of the converted string is : "+infixToPostfix(exp));
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

    static String infixToPostfix(String exp){
        String result=new String("");
        Deque<Character> stack=new ArrayDeque<Character>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c=='(')
                stack.push(c);
             else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
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
