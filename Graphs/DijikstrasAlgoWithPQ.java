package Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DijikstrasAlgoWithPQ {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};
        System.out.println("The minimum cost path for "+minimumCostPath(grid));
    }

    public static int minimumCostPath(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        int res=0;

        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        PriorityQueue<Pair> pq=new PriorityQueue<>(n*m,new DistanceComparator());
        pq.add(new Pair(0,0,dist[0][0]));

        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            for(int i=0;i<4;i++){
                int rows=curr.x+dx[i];
                int cols=curr.y+dy[i];

                if(isValid(rows, cols, grid)){
                    if(dist[rows][cols]>dist[curr.x][curr.y]+grid[curr.x][curr.y]){
                        if(dist[rows][cols]!=Integer.MAX_VALUE){
                            Pair adj=new Pair(rows,cols,dist[rows][cols]);
                            pq.remove(adj);
                        }
                    }
                }

                dist[rows][cols]=dist[curr.x][curr.y]+grid[rows][cols];
                pq.add(new Pair(rows,cols,dist[rows][cols]));
            }
        }

        return dist[n-1][m-1];
    }

    static boolean isValid(int x,int y,int[][] grid){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length;
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

class DistanceComparator implements Comparator<Pair>{
    public int compare(Pair p1,Pair p2){
        return p1.dist-p2.dist;
    }
}