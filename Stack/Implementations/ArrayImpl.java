public class ArrayImpl{
    public static void main(String[] args) {
        MyStack s=new MyStack(3);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop());
    }
}


class MyStack{
    int[] arr;
    int cap;
    int top;
 
    MyStack(int c){
        top=-1;
        cap=c;
        arr=new int[cap];
    }


    void push(int x){
        if(top==cap-1){
            System.out.println("Stack Overflow!!");
            return;
        }

        arr[++top]=x;
    }

    int pop(){
        if(top==-1){
            System.out.println("Stack Underflow!!");
            return -1;
        }
        int res=arr[top--];
        return res;
    }

    int peek(){
        return arr[top];
    }

    boolean isEmpty(){
        return top==-1;
    }

    int size(){
        return top+1;
    }

}