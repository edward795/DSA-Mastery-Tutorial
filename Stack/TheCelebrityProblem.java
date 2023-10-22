import java.util.Stack;

public class TheCelebrityProblem {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{0,1,0},{0,0,0},{0,1,0}};
        System.out.println("celebrity is "+isCelebrity(arr,3));
    }

    static boolean knows(int[][]m,int a,int b){
        return m[a][b]==1?true:false;
    }

   //TC : O(n) - O(n) 
   static int isCelebrity(int[][] arr,int n){
        Stack<Integer> st=new Stack<>();
        int c;
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1){
            int a=st.pop();
            int b=st.pop();
            if(knows(arr,a,b)){
                st.push(b);
            }else{
                st.push(a);
            }
        }

        if(st.isEmpty()) return -1;
        c=st.pop();
        for(int i=0;i<n;i++){
            if(i!=c && (knows(arr,c,i)) || !knows(arr,i,c)) return -1;
        }

        return c;
    }
}
