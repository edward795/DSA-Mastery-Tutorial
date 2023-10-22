import java.util.Stack;

public class MaxOfMinInRangeOfArray{
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 50, 10, 70, 30 };
        maxOfMin(arr);
    }

    //Naive Soln : O(n^3)
    // static void maxOfMin(int[] arr){
    //     for(int k=1;k<=n;k++){
    //         int maxOfMin=Integer.MIN_VALUE;
    //         for(int i=0;i<=n-k;i++){
    //             int min=arr[i];
    //             for(int j=1;j<k;j++){
    //                 if(arr[i+j]<min)
    //                     min=arr[i+j];
    //             }
    //         }
    //         if(min>maxOfMin)
    //             maxOfMin=min;
    //         System.out.print(maxOfMin+" ");
    //     }
        
    // }

    //Efficient Soln  : O(n) - O(n)
    static void maxOfMin(int[] arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[] left=new int[n+1];
        int[] right=new int[n+1];

        for(int i=0;i<n;i++){
            left[i]=-1;
            right[i]=n;
        }
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty())
                left[i]=st.peek();
            st.push(i);
        }

        while(!st.isEmpty())
            st.pop();

        for(int i=n;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(!st.isEmpty()) 
                right[i]=st.peek();
            st.push(i);
        }

        int[] ans=new int[n+1];
        for(int i=0;i<n;i++){
            ans[i]=0;
        }

        for(int i=0;i<n;i++){
            int len=right[i]-left[i]-1;
            ans[len]=Math.max(ans[len],arr[i]);
        }

        for(int i=n-1;i>=1;i++){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }

        for(int i=1;i<=n;i++){
            System.out.print(ans[i-1]+" ");
        }
    }
}