package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class MinimumCostPath {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};
        System.out.println(minimumCostPath(grid));
    }

    public static int minimumCostPath(int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        int[][] dist=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        dist[0][0]=grid[0][0];
        q.add(new Pair(0,0, 0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            int dx[]={-1,0,1,0};
            int dy[]={0,1,0,-1};

            for(int i=0;i<4;i++){
                int xn=p.x+dx[i];
                int yn=p.y+dy[i];

                if(isValid(xn,yn,grid) && dist[xn][yn]>dist[p.x][p.y]+grid[xn][yn]){
                    dist[xn][yn]=dist[p.x][p.y]+grid[xn][yn];
                }
            }
        }
        return dist[grid.length-1][grid.length-1];
    }

    private static boolean isValid(int xn, int yn, int[][] grid) {
        return xn>-1 && xn<grid.length && yn>-1 && yn<grid[0].length;
    }
}

class Pair{
    int x,y,dist;

    Pair(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
