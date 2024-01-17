import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;

public class FindTheNoOfIslands {
    static int N=6;
    public static void main(String[] args) {
        int[] knightPos=new int[]{4,5};
        int[] targetPos=new int[]{1,1};
        System.out.println(minStepToReachTarget(knightPos, targetPos, N));
    }
    public static int minStepToReachTarget(int[] knightPos,int targetPos[],int n) {
        boolean[][] visited=new boolean[N+1][N+1];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(knightPos[0],knightPos[1], N));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(curr.x==knightPos[0] && curr.y==knightPos[1]){
                return curr.dis;
            }

            int dx[]={-1,-2,-2,-1,1,2,2,1};
            int dy[]={2,1,-1,-2,-2,-1,1,2};

            for(int i=0;i<8;i++){
                int xn=curr.x+dx[i];
                int yn=curr.y+dy[i];

                if(isValid(xn,yn,N) && !visited[xn][yn]){
                    q.add(new Pair(xn,yn,curr.dis+1));
                    visited[xn][yn]=true;
                }
            }
        }
        return -1;
    }

    static boolean isValid(int x,int y,int n){
        return x>=1 && x<=n && y>=1 && y<=n;
    }
}

class Pair{
    int x,y,dis;
    Pair(int x,int y,int dis){
        this.x=x;
        this.y=y;
        this.dis=dis;
    }
}