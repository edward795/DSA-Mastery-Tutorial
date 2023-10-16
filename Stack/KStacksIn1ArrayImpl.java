package Stack;

public class KStacksIn1ArrayImpl {
    public static void main(String[] args) {
        int n=5,k=3;
        KStacks st=new KStacks(5, 3);
        st.push(1,100);
        st.push(1,200);
        System.out.println(st.isEmpty(2));
        System.out.println(st.isEmpty(1));
        System.out.println(st.pop(1));
    }
}


class KStacks{
    int[] arr;
    int[] next,top;
    int free_top,cap,k;

    KStacks(int n,int k){
        arr=new int[n];
        next=new int[n];
        top=new int[k];
        free_top=0;
        cap=n;
        k=k;


        for(int i=0;i<n-1;i++)
            next[i]=i+1;
        arr[n-1]=-1;

        for(int i=0;i<k;i++) 
            top[i]=-1;
    }

    void push(int sn,int x){
        int i=free_top;
        free_top=next[i];
        next[i]=top[sn];
        top[sn]=i;
        arr[i]=x;
    }

    int pop(int sn){
        int i=top[sn];
        top[sn]=next[i];
        next[i]=free_top;
        free_top=i;
        return arr[i];
    }

    boolean isEmpty(int sn){
        return top[sn]==-1;
    }
}