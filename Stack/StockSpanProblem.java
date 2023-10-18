package Stack;

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr=new int[]{13,15,12,14,16,8,6,4,10,30};
        int[] res=printSpan(arr);
        for(Integer i:res) 
            System.out.print(i+" ");
    }

    //Naive Soln : O(n^2) - O(1)
    // static int[] printSpan(int[] arr){
    //     int n=arr.length;
    //     int[] span=new int[n];
    //     span[0]=1;
    //     for(int i=1;i<n;i++){
    //         span[i]=1;
    //         for(int j=i-1;j>=0 && arr[i]>arr[j];j--){
    //             span[i]++;
    //         }
    //     }
    //     return span;
    // }

    //Efficient Soln : O(n) - O(n)
    static int[] printSpan(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] span=new int[n];
        st.push(0);
        span[0]=1;
        for(int i=1;i<n;i++){
            while(st.isEmpty()==false && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            span[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return span;
    }
}
