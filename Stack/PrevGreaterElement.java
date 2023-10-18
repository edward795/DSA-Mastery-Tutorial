package Stack;

import java.util.Stack;

public class PrevGreaterElement {
    public static void main(String[] args) {
        int[] arr=new int[]{15,10,18,12,4,6,2,8};
        previousGreater(arr);
    }

    //Naive Soln :O(n^2)
    // static void previousGreater(int[] arr){
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         int j;
    //         for(j=i-1;j>=0;j--){
    //             if(arr[j]>arr[i]){
    //                 System.out.print(arr[j]+" ");
    //                 break;
    //             }
    //         }
    //         if(j==-1) System.out.print(-1+" ");
    //     }
    // }

    //Efficient Soln : O(n) - O(n)
    static void previousGreater(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.add(0);
        System.out.print(-1+" ");
        for(int i=1;i<n;i++){
            while(st.isEmpty()==false && arr[st.peek()]<arr[i]){
                st.pop();
            }
            int pg=st.isEmpty()?-1:arr[st.peek()];
            st.push(i);
            System.out.print(pg+" ");
        }
    }
}
