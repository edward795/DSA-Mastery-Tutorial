package Graphs;

import java.util.ArrayList;

public class DFSWithoutSource {
    public static void main(String[] args) {
        int v=7;
        Graph g=new Graph(v);
        ArrayList<ArrayList<Integer>> adj=g.getDisconnectedGraph();
        DFS(adj,v);
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s){
        visited[s]=true;
        System.out.print(s+" "); 

        for(int u:adj.get(s)){
            if(!visited[u])
                DFSRec(adj, visited, u);
        }
    }

    //TC : O(V+E)
    static void DFS(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]) 
                DFSRec(adj,visited,i);
        }
    }
}
