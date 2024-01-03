package Graphs;

import java.util.LinkedList;
import java.util.Queue;



public class RottenTomatoes {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1,2},{0,1,2},{2,1,1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid){
        int res=0;
        int[][] ans=new int[grid.length][grid[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    ans[i][j]=0;
                }else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }

            while(!q.isEmpty()){
                Pair point=q.peek();
                int x=point.x;
                int y=point.y;
                if(isValid(grid,x+1,y) && ans[x+1][y]>ans[x][y]+1){
                    ans[x+1][y]=ans[x][y]+1;
                    q.add(new Pair(x+1,y));
                }

                if(isValid(grid,x,y+1) && ans[x][y+1]>ans[x][y]+1){
                    ans[x][y+1]=ans[x][y]+1;
                    q.add(new Pair(x,y+1));
                }

                if(isValid(grid, x-1, y) && ans[x-1][y]>ans[x][y]+1){
                    ans[x-1][y]=ans[x][y]+1;
                    q.add(new Pair(x-1,y));
                }

                if(isValid(grid, x, y-1) && ans[x][y-1]>ans[x][y]+1){
                    ans[x][y-1]=ans[x][y];
                    q.add(new Pair(x,y-1));
                }
                q.remove();
            }

        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res=Math.max(res,ans[i][j]);
            }
        }
        return res;
    }

    static boolean isValid(int[][] grid,int x,int y){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length;
    }
}

class Pair{
    int x,y;

    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

