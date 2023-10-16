package Stack;

public class TwoStacksIn1ArrayImpl {
    public static void main(String[] args) {
        TwoStacks st=new TwoStacks(5);
        st.push1(1);
        st.push1(2);
        st.push1(3);
        System.out.println(st.size1());
        st.push2(10);
        st.push2(20);
        st.push2(30);
        System.out.println(st.size2());
    }
}

class TwoStacks{
    int[] arr;
    int cap,top1,top2;

    TwoStacks(int c){
        arr=new int[c];
        cap=c;
        top1=-1;
        top2=c;
    }

    boolean push1(int x){
        if(top1<top2-1){
            arr[++top1]=x;
            return true;
        }
        return false;
    }

    boolean push2(int x){
        if(top1<top2-1){
            arr[--top2]=x;
            return true;
        }
        return false;
    }

    Integer pop1(){
        if(top1>0){
            int x=arr[top1];
            top1--;
            return x;
        }
        return null;
    }


    Integer pop2(){
        if(top2<cap){
            int x=arr[top2];
            top2++;
            return x;
        }
        return null;
    }

    int size1(){
        return (top1+1);
    }

    int size2(){
        return (cap-top2);
    }
}
