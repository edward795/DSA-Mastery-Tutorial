package Stack;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class MaxRectangularAreaInHistogram {
    public static void main(String[] args) {
        int[] arr=new int[]{6,2,5,4,1,5,6};
        System.out.println(getMaxArea(arr));
    }

    //Naive soln : O(n^2)
    // static int getMaxArea(int[] arr){
    //     int n=arr.length;
    //     int res=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         int curr=arr[i];
    //         for(int j=i-1;j>=0;j--){
    //             if(arr[j]>=arr[i]) curr+=arr[i];
    //             else break;
    //         }

    //         for(int j=i+1;j<n;j++){
    //             if(arr[j]>=arr[i]) curr+=arr[i];
    //             else break;
    //         }

    //         res=Math.max(res,curr);
    //     }
    //     return res;
    // }

    //Better approach but 3 traversals & aux arrays - O(n)
    // static int getMaxArea(int[] arr){
    //     int n=arr.length;
    //     int[] ps=new int[n];
    //     int[] ns=new int[n];
    //     int ans=Integer.MIN_VALUE;

    //     Stack<Integer> st1=new Stack<>();
    //     Stack<Integer> st2=new Stack<>();
    //     Vector<Integer> res=new Vector<>();

    //     st1.add(0);
    //     ps[0]=-1;
        
    //     for(int i=1;i<n;i++){
    //         while(!st1.isEmpty() && arr[st1.peek()]>=arr[i]){
    //             st1.pop();
    //         }

    //         int res1=st1.isEmpty()?-1:arr[st1.peek()];
    //         ps[i]=res1;
    //         st1.push(i);
    //     }

    //     st2.add(n-1);
    //     ns[n-1]=-1;

    //     for(int i=n-2;i>=0;i--){
    //         while(!st2.isEmpty() && arr[st2.peek()]>=arr[i]){
    //             st2.pop();
    //         }
    //         int res2=st2.isEmpty()?-1:arr[st2.peek()];
    //         res.add(res2);
    //         st2.add(i);
    //     }

    //     Collections.reverse(res);
    //     for(int i=0;i<n-1;i++) 
    //         ns[i]=res.get(i);

    //     for(int i=0;i<n;i++){
    //         int curr=arr[i];
    //         curr+=(i-ps[i]-1)*arr[i];
    //         curr+=(ns[i]-i-1)*arr[i];
    //         ans=Math.max(ans,curr);
    //     }
    //     return ans;
    // }

    //Efficient Soln : O(n) -O(n)
    static int getMaxArea(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int res=0;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                int ele=st.pop();
                curr=arr[ele]*(st.isEmpty()?i:(i-st.peek()-1));
                res=Math.max(res,curr);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int ele=st.pop();
            int curr=arr[ele]*(st.isEmpty()?n:(n-st.peek()-1));
            res=Math.max(res,curr);
        }
        return res;
    }
}
