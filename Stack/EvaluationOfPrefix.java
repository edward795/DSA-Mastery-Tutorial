package Stack;

import java.util.Stack;

public class EvaluationOfPrefix {
    public static void main(String[] args) {

        String exp="+ 9 * 12 6";
        // String exp="+9*26";
        System.out.println("Evaluated Prefix value is : "+evaluationOfPrefix(exp));
    }

    //TC : O(n) - O(n)
    // static int evaluationOfPrefix(String exp){
    //     Stack<Integer> st=new Stack<>();
    //     for(int i=exp.length()-1;i>=0;i--){
    //         char c=exp.charAt(i);
    //         if(Character.isDigit(c))
    //             st.push(c-'0');
    //         else{
    //             int o1=st.pop();
    //             int o2=st.pop();
    //             int res=eval(c,o1,o2);
    //             st.push(res);
    //         }
    //     }
    //     return st.peek();
    // }

    //TC : O(n) - O(n)
    static int evaluationOfPrefix(String exp){
        Stack<Integer> st=new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char c=exp.charAt(i);
            if(c==' ')
                continue;
            else if(Character.isDigit(c)){
                int res=0,j=i;
                while(Character.isDigit(c) && i<exp.length()){
                    i--;
                    c=exp.charAt(i);
                }
                i++;
                for(int k=i;k<=j;k++){
                    res=res*10+(int)(exp.charAt(k)-'0');
                }
                st.push(res);
            }else{
                int o1=st.pop();
                int o2=st.pop();
                int res=eval(c,o1,o2);
                st.push(res);
            }
        }
        return st.peek();
    }

    static int eval(char c,int o1,int o2){
        switch(c){
            case '+': 
                return o1+o2;
            case '-':
                return o1-o2;
            case '/':
                return o1/o2; 
            case '*':
                return o1*o2;
        }
        return -1;
   }
}
