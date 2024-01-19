public class CountDistinctXGrids {
    public static void main(String[] args) {
        char[][] grid=new char[][]{{'x','o','x'},{'o','x','o'},{'x','x','x'}};
        System.out.println("No of x shapes : "+xShape(grid));
    }

    static boolean isValid(int x,int y,int[][] grid){
        return x>-1 && x<grid.length && y>-1 && y<grid[0].length;
    }

    public void dfs(int x,int y,char[][] grid,boolean[][] visited){
        visited[x][y]=true;
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};

        for(int i=0;i<4;i++){
            int xn=x+dx[i];
            int yn=y=dy[i];

            if(isValid(xn,yn,grid) && !visited[xn][yn] && grid[xn][yn]=='x'){
                dfs(xn,yn,grid,visited);
            }
        }
    }

    public int xShape(char[][] grid){
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='x' && !visited[i][j]){
                    dfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        return count;
    }
}
