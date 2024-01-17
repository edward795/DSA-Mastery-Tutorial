import java.util.Queue;

import LinkedList.utils.LinkedList;

public class BFSBasedFindIfPathExist {
    public static void main(String[] args) {
        
    }
    public boolean isValid(int x,int y,int[][] grid){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length && grid[x][y]!=0;
    }

    public boolean isPossible(int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                q.add(new Pair(i,j));
                visited[i][j]=true;
            }
        }
        
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};

        while(!q.isEmpty()){
            Pair p=q.poll();
            for(int i=0;i<4;i++){
                int xn=p.x+delRow[i];
                int yn=p.y+delCol[i];

                if(isValid(xn,yn,grid) && !visited[xn][yn] && grid[xn][yn]==2) return true;

                if(isValid(xn,yn,grid) && !visited[xn][yn]){
                    visited[xn][yn]=true;
                    q.add(new Pair(xn,yn));
                }
            }
        }

        return false;
    }

}

class Pair{
    int x,y;

    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
