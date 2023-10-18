package Stack;

import java.util.Stack;

public class GetMinOfAStack {
    public static void main(String[] args) {
        MyStack st=new MyStack();
        st.push(10);
        st.getMin();
        st.push(5);
        st.getMin();
        st.push(2);
        st.getMin();
        st.pop();
        st.getMin();
    }
}


//Efficient Approach using 2 stacks : main stack & an aux stack - O(n) - O(n)
// class MyStack{
//     Stack<Integer> main;
//     Stack<Integer> aux;
    
    
//     MyStack(){
//         main=new Stack<>();
//         aux=new Stack<>();
//     }

//     void push(int x){
//         main.push(x);
//         if(!aux.isEmpty() && aux.peek()>main.peek()) 
//             aux.push(x);
//         if(aux.isEmpty()) aux.push(x);
//         System.out.println("getMin() : "+aux.peek());
//     }

//     void pop(){
//         if(aux.peek()==main.peek() && !aux.isEmpty()) 
//              aux.pop();
//          main.pop();
//         System.out.println("getMin() : "+aux.peek());
//     }
// }

//Efficient Soln : O(n) - O(1)
// class MyStack{

//     class Node{
//         int val;
//         int min;

//         public Node(int val,int min){
//             this.val=val;
//             this.min=min;
//         }
//     }
//     Stack<Node> st;

//     MyStack(){
//         st=new Stack<>();
//     }

//     void push(int x){
//         if(st.isEmpty()){
//             st.push(new Node(x,x));
//         }else{
//             int min=Math.min(st.peek().min,x);
//             st.push(new Node(x,min));
//         }
//     }

//     int pop(){
//         return st.pop().val;
//     }

//     int peek(){
//         return st.peek().val;
//     }

//     void getMin(){
//         System.out.println("getMin() : "+st.peek().min);
//     }
// }

// class MyStack{
//     Stack<Integer> st;
//     int min;

//     MyStack(){
//         st=new Stack<>();
//         min=Integer.MAX_VALUE;
//     }

//     void push(int x){
//         if(st.isEmpty()){
//             min=x;
//             st.push(x);
//         }else if(x<=min){
//             st.push(x-min);
//             min=x;
//         }else{
//             st.push(x);
//         }
//     }

//     int pop(){
//         int t=st.pop();
//         if(t<=0){
//             int res=min;
//             min=min-t;
//             return res;
//         }else{
//             return t;
//         }
//     }

//     int getMin(){
//         return min;
//     }

//     int peek(){
//         int t=st.peek();
//         return (t<=0)?min:t;
//     }
// }

class MyStack{
    Stack<Integer> st;
    int min;


    MyStack(){
        st=new Stack<>();
        min=Integer.MAX_VALUE;
    }


    void push(int x){
        if(st.isEmpty()){
            min=x;
            st.push(x);
        }else if(x<=min){
            st.push(2*x-min);
            min=x;
        }else{
            st.push(x);
        }
    }

    int pop(){
        int t=st.pop();
        if(t<=min){
            int res=min;
            min=2*min-t;
            return res;
        }
        return t;
    }

    int getMin(){
        return min;
    }

    int peek(){
        int t=st.peek();
        return (t<=min)?min:t;
    }
}