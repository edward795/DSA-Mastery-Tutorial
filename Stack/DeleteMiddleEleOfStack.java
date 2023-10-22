package Stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class DeleteMiddleEleOfStack {
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        st.push('a');
        st.push('b');
        st.push('c');
        st.push('d');
        st.push('e');
        // deleteMiddle(st);
        deleteMiddle(st, st.size()-1, 0);
        while(!st.isEmpty())
            System.out.print(st.pop()+" ");
    }
    
    //TC : O(n) - O(n)
    // static void deleteMiddle(Stack<Character> st){
    //     Vector<Character> v=new Vector<>();
    //     while(!st.isEmpty()){
    //         v.add(st.pop());
    //     }
         
    //     int n=v.size();
    //     if(n%2==0){
    //         int midPos=n/2;
    //         for(int i=0;i<n;i++){
    //             if(i==midPos) continue;
    //             st.push(v.get(i));
    //         }
    //     }else{
    //         int midPos=(int) Math.ceil(n/2);
    //         for(int i=0;i<n;i++){
    //             if(i==midPos) continue;
    //             st.push(v.get(i));
    //         }
    //     }

    //     while(!st.isEmpty())
    //         System.out.print(st.pop());
    // }

    //TC : O(n) - O(1)
    static void deleteMiddle(Stack<Character> st,int n,int curr){
        if(curr==n || st.isEmpty()) return;

        char x=st.pop();

        deleteMiddle(st, n, curr+1);
        if(curr!=n/2){
            st.push(x);
        }
    }
}
