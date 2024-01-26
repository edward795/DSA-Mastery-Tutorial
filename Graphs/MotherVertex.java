package Graphs;

import java.util.ArrayList;

public class MotherVertex {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("The Mother Vertex of the directed grapgh is "+findMotherVertex(0,g.adj));
    }

    public static void dfs(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[s]=true;
        for(int i:adj.get(s)){
            if(!visited[i]){
                dfs(i,adj,visited);
            }
        }
    }

    public static int findMotherVertex(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[V];
        int res=-1;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                res=i;
            }
        }

        visited=new boolean[V];
        dfs(res,adj,visited);
        for(boolean i:visited){
            if(i==false){
                return -1;
            }
        }
        return res;
    }
}
