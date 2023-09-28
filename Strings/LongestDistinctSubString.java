import java.util.Arrays;

public class LongestDistinctSubString {
    public static void main(String[] args) {
        String str="abcdabc";
        System.out.println("Longest substring with distinct characters is of length : "+LongestDistinctSubString(str));
    }


    //Naive Soln : o(n^3)
    // static int LongestDistinctSubString(String str){
    //     int n=str.length();
    //     int res=0;
    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(areDistinct(str,i,j))
    //                 res=Math.max(res,j-i+1);
    //         }
    //     }
    //     return res;
    // }

    // static boolean areDistinct(String str,int i,int j){
    //     boolean[] visited=new boolean[256];
    //     for(int k=i;k<=j;k++){
    //         if(visited[str.charAt(k)]==true) 
    //             return false;
    //         visited[str.charAt(k)]=true;
    //     }
    //     return true;
    // }
    
    //Better Soln :O(n^2)
    // static int LongestDistinctSubString(String str){
    //     int res=0,n=str.length();
    //     boolean[] visited=new boolean[256];

    //     for(int i=0;i<n;i++){
    //         for(int j=i;j<n;j++){
    //             if(visited[str.charAt(j)]==true) 
    //                 break;
    //             else{
    //                 res=Math.max(res,j-i+1);
    //                 visited[str.charAt(j)]=true;
    //             }
    //         }
    //     }
    //     return res;
    // }

    //Efficient Soln : O(n)
    static int LongestDistinctSubString(String str){
        int res=0,n=str.length();
        int[] lastIndex=new int[256];

        Arrays.fill(lastIndex,-1);
        int i=0;
        for(int j=0;j<n;j++){
            i=Math.max(i,lastIndex[str.charAt(j)]+1);
            res=Math.max(res,j-i+1);

            lastIndex[str.charAt(j)]=j;
        }
        return res;
    }
}
