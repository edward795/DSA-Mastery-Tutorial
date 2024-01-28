package Graphs;

import java.util.ArrayList;

public class UnitAreaOfLargestRegionOfOnes{

    static ArrayList<Integer> al=new ArrayList<>();
    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,1,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println("Unit Area Of Largest Region : "+findMaxAres(grid));
    }

    static void dfs(int x,int y,boolean[][] visited,int[][] grid,ArrayList<Integer> res){
        visited[x][y]=true;
        res.add(grid[x][y]);
        int[] dx={0,-1,-1,-1,0,1,1,1};
        int[] dy={-1,-1,0,1,1,1,0,-1};

        for(int i=0;i<8;i++){
            int xn=x+dx[i];
            int yn=y+dy[i];

            if(isValid(xn,yn,grid) && !visited[xn][yn]){
                dfs(xn,yn,visited,grid,res);
            }
        }
    }

    public static int findMaxAres(int[][] grid){
        int res=Integer.MIN_VALUE;
        boolean[][] visited=new boolean[grid.length][grid[0].length];

        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    dfs(i, j, visited, grid, al);
                    res=Math.max(res,al.size());
                    al.clear();
                }
            }
        }
        return res;
    }

    static boolean isValid(int x,int y,int[][] grid){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length;
    }
}