package Stack;

import java.util.Stack;

public class LongestRectangleWith1s {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{0,1,1,0},{1,1,1,1},{1,1,1,1},{1,1,0,0}};
        System.out.println("Max value of histogram retcngle with 1's "+maxReactangle(arr));
    }

    static int maxReactangle(int[][] arr){
        int n=arr.length,m=arr[0].length;
        int res=Integer.MIN_VALUE;

        res=maxHist(n, m,arr[0]);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    arr[i][j]+=arr[i-1][j];
                }
                res=Math.max(res,maxHist(m,n,arr[i]));
            }
        }
        return res;
    }


    static int maxHist(int r,int c,int row[]){
        Stack<Integer> st=new Stack<>();
        int top_val;
        int max_area=0;
        int area=0;
        int i=0;
        while(i<c){
            if(st.isEmpty() || row[st.peek()]<=row[i]){
                st.push(i++);
            }else{
                top_val=row[st.peek()];
                st.pop();
                area=top_val*i;
                if(!st.isEmpty())
                    area=top_val*(i-st.peek()-1);
                max_area=Math.max(area,max_area);
            }
        }

        while(!st.isEmpty()){
            top_val=row[st.peek()];
            st.pop();
            area=top_val*i;
            if(!st.isEmpty())
                area=top_val*(i-st.peek()-1);
            max_area=Math.max(area,max_area);
        }
        return max_area;
    }
}
