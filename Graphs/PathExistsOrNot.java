package Graphs;

public class PathExistsOrNot {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{3,0,3,0,0},{3,0,0,0,3},{3,3,3,3,3},{0,2,3,0,0},{3,0,0,1,3}};
    }

    static boolean isValid(int[][] grid,int x,int y,boolean[][] visited){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length && !visited[x][y];
    }

    public boolean dfs(int[][] grid,int x,int y,boolean[][] visited){
        visited[x][y]=true;
        int[] dx=new int[]{-1,0,1,0};
        int[] dy=new int[]{0,1,0,-1};
        for(int i=0;i<4;i++){
            int xn=x+dx[i];
            int yn=y+dy[i];

            if(grid[xn][yn]==2 && isValid(grid, xn, yn, visited)){
                visited[xn][yn]=true;
                return true;
            }

            if(isValid(grid, xn, yn, visited) && grid[xn][yn]==3){
                if(dfs(grid, xn, yn, visited)==true) return true;
            }
        }
        return false;
    }

    public boolean isPossible(int[][] grid){
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    if(dfs(grid,i,j,visited)==true) return true;
                }
            }
        }
        return false;
    }
}
