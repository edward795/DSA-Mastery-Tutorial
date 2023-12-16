package Graphs;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);

        System.out.println("is the following directed graph cyclic : ?"+DFS(g.adj,6));
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited,boolean recSt[]){
        visited[s]=true;
        recSt[s]=true;

        for(int u:adj.get(s)){
            if(!visited[u] && DFSRec(adj,u,visited,recSt)){
                return true;
            }
            if(recSt[u]==true) 
                return true;
        }

        recSt[s]=false;
        return false;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited=new boolean[v+1];
        boolean[] recSt=new boolean[v+1];
        for(int i=0;i<v;i++){
            if(!visited[i])
                if(DFSRec(adj,i,visited,recSt)) 
                    return true;
        }
        return false;
    }
}
