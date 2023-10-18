package Stack;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[]{5,15,10,8,6,12,9,18};
        nextGreater(arr);
    }

    //Naive Soln : O(n^2)
    // static void nextGreater(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int j;
    //         for(j=i+1;j<n;j++){
    //             if(arr[j]>arr[i]){
    //                 System.out.print(arr[j]+" ");
    //                 break;
    //             }
    //         }
    //     }
    //     System.out.print(-1+" ");
    // }

    //Efficient Soln : O(n) - O(n)
    static void nextGreater(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.push(n-1);
        Vector<Integer> res=new Vector<>();
        res.add(-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            int ng=st.isEmpty()?-1:arr[st.peek()];
            res.add(ng);
            st.push(i);
        }
        Collections.reverse(res);
        for(Integer i:res)
            System.out.print(i+" ");
    }
}
