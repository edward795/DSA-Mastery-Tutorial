package Graphs;

public class AdjacencyMatrixRepr {

    public static void main(String[] args) {
        int v=4;
        int[][] mat=new int[v][v];

        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 1, 3);

        printGraph(mat);
    }

    static void addEdge(int[][] mat,int i,int j){
        mat[i][j]=1;
        mat[j][i]=1;
    }

    static void printGraph(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
