package Graphs;

import java.util.LinkedList;
import java.util.Queue;


public class DistanceOfCellWithOne {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1,1,0},{1,1,0,0},{0,0,1,1},{1,0,0,1},{0,0,1,1},{1,1,0,0}};
        for(int[] i:nearest(grid)){
            for(int j:i)
                System.out.println(i+" ");
        }
    }

    public static int[][] nearest(int[][] grid){
        int ans[][]=new int[grid.length][grid[0].length];
        Queue<Pair> coordinates=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans[i][j]=0;
                    coordinates.add(new Pair(i,j));
                }else{
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }

        while(coordinates.isEmpty()){
            int x=coordinates.peek().x;
            int y=coordinates.peek().y;

            if(isValid(x-1, y, grid) && ans[x-1][y]>ans[x][y]+1){
                ans[x-1][y]=ans[x][y]+1;
                coordinates.add(new Pair(x-1,y));
            }

            if(isValid(x, y-1, grid) && ans[x][y-1]>ans[x][y]-1){
                ans[x][y-1]=ans[x][y]+1;
                coordinates.add(new Pair(x,y-1));
            }

            if(isValid(x-1, y, grid) && ans[x-1][y]>ans[x][y]+1){
                ans[x-1][y]=ans[x][y]+1;
                coordinates.add(new Pair(x-1,y));
            }

            if(isValid(x, y-1, grid) && ans[x][y-1]>ans[x][y]+1){
                ans[x][y-1]=ans[x][y]+1;
                coordinates.add(new Pair(x, y-1));
            }
            coordinates.remove();
        }
        return ans;
    }

    public static boolean isValid(int x,int y,int[][] grid){
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
