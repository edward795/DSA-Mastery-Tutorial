package Graphs;

public class FindNoOfIslands {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1},{1,0},{1,1},{1,0}};
        System.out.println("num of islands is "+numIslands(grid));
    }

    static boolean isValid(int x,int y,boolean[][] visited,int[][] grid){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length && !visited[x][y];
    }

    static void dfs(int x,int y,boolean[][] visited,int[][] grid){
        visited[x][y]=true;
        int dx[]={0,0,1,-1,1,1,-1,-1};
        int dy[]={1,-1,0,0,1,-1,-1,1};

        for(int i=0;i<8;i++){
            int xn=x+dx[i];
            int yn=y+dy[i];

            if(isValid(xn, yn, visited, grid) && grid[xn][yn]==1){
                dfs(xn,yn,visited,grid);
            }
        }
    }

    static int numIslands(int[][] grid){
        boolean[][] visited=new boolean[grid.length][grid.length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
}
