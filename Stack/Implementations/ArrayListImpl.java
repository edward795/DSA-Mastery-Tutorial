import java.util.ArrayList;

public class ArrayListImpl {
    public static void main(String[] args) {
        MyStack st=new MyStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
    }
}

class MyStack{
    ArrayList<Integer> arr;

    MyStack(){
        arr=new ArrayList<>();
    }

    void push(int x){
        arr.add(x);
    }

    int pop(){
        int res=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return res;
    }

    int peek(){
        return arr.get(arr.size()-1);
    }

    boolean isEmpty(){
        return arr.size()==0;
    }

    int size(){
        return arr.size();
    }
}
