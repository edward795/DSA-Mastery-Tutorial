package Backtracking;

import java.util.Arrays;

public class MColoringProblem {
    public static void main(String[] args) {
        int n=4,m=3;
        int[][] graph=new int[][]{{0,1},{1,2},{2,3},{3,0},{0,2}};
        System.out.println("Is it possible to color it uniquely : "+ graphColouring(graph,m,n));
    }

    //TC : O(m^n) - O(n)
    public static boolean graphColouring(int[][] graph,int m,int n){
        int[] color=new int[n];
        Arrays.fill(color,-1);
        return solve(graph,color,0,m);
    }

    public static boolean solve(int[][] graph,int[] color,int index,int m){
        if(index==graph.length-1){
            return true;
        }

        for(int i=1;i<=m;i++){
            if(isValid(graph,color,index,i)==true){
                color[index]=i;
                if(solve(graph,color,index+1,m)==true)
                    return true;
                color[index]=-1;
            }
        }
        return false;
    }

    static boolean isValid(int[][] graph,int[] color,int index,int m){
        for(int i=0;i<graph[index].length;i++){
            if(graph[index][i]==1){
                if(color[i]==m) return false;
            }
        }
        return true;
    }
}
