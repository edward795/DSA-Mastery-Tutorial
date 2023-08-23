package Recursion;

public class RopeCuttingProblem {
    public static void main(String[] args) {
       int n=5,a=2,b=5,c=1; 
       System.out.println("max pieces in which the rope can be cut:"+maxPieces(n, a, b, c));
    }
    

    //Time Complexity: O(3^n)
    public static int maxPieces(int n,int a,int b,int c){
        if(n==0) return 0;
        if(n<0) return -1;

        int res=Math.max(maxPieces(n-a, a, b, c),Math.max(maxPieces(n-b, a, b, c),maxPieces(n-c, a, b, c)));
        if(res==-1) return -1;
        return res+1;
    }
    
}
