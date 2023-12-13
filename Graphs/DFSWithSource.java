package Graphs;

import java.util.ArrayList;

public class DFSWithSource {
    public static void main(String[] args) {
        int v=6;
        Graph g=new Graph(v);
        ArrayList<ArrayList<Integer>> adj=g.getConnectedGraph();
        boolean visited[]=new boolean[v+1];

        DFSRec(adj, v, visited);
    }

    //TC : O(V + E)
    static void DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited){
        visited[s]=true;
        System.out.print(s+" ");

        for(int u:adj.get(s)){
            if(!visited[u])
                DFSRec(adj, u, visited);
        }
    }
}
