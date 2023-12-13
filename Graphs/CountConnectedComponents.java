package Graphs;

import java.util.ArrayList;

public class CountConnectedComponents {
    public static void main(String[] args) {
        int v=7;
        Graph g=new Graph(v);
        ArrayList<ArrayList<Integer>> adj=g.getConnectedGraph();
        DFS(adj, v);
    }

    //TC : O(V+E)
    static void DFS(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited=new boolean[v];
        int count=0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                count++;
                DFSRec(adj,visited,i);
            }
        }
        System.out.println("Count of disconnected components in array is "+count);
    }

    static void DFSRec(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int s){
        visited[s]=true;
        System.out.print(s+" ");

        for(int u:adj.get(s)){
            if(!visited[u]){
                DFSRec(adj, visited, u);
            }
        }
    }
}
