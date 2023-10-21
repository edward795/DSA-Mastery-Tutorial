package Stack;

import java.util.Stack;

public class EvaluationOfPostFix {
   public static void main(String[] args) {
        // String exp="231*+9-";
        String exp="100 200 + 2 / 5 * 7 +";
        System.out.println("Evaluated PostFix is : "+evaluatePostFix(exp));
   } 
//Works only for single digits - O(n) - O(n)
//    static int evaluatePostFix(String exp){
//      Stack<Integer> st=new Stack<>();
//      for(int i=0;i<exp.length();i++){
//         char c=exp.charAt(i);
//         if(Character.isDigit(exp.charAt(i))){
//             st.push(c-'0');
//         }else{
//             int o1=st.pop();
//             int o2=st.pop();
//             int res=eval(c,o2,o1);
//             st.push(res);
//         }
//      }
//      return st.peek();
//    }


   static int evaluatePostFix(String exp){
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<exp.length();i++){
        char c=exp.charAt(i);
        if(c==' ') continue;
        else if(Character.isDigit(c)){
            int res=0;
            while (Character.isDigit(c)) {
                res=res*10+(int)(c-'0');
                i++;
                c=exp.charAt(i);
            }
            i--;
            st.push(res);
        }else{
            int o1=st.pop();
            int o2=st.pop();
            st.push(eval(c,o2,o1));
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
