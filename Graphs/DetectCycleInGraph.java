package Graphs;

import java.util.ArrayList;

public class DetectCycleInGraph {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        System.out.println(DFS(g.adj,5));
    }

    static boolean DFSRec(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited,int parent){
        visited[s]=true;
        for(int u:adj.get(s)){
            if(DFSRec(adj, u, visited, s)==true)
                 return true;
            else if(u!=parent)
                 return true;
        }
        return false;
    }

    //TC : O(V + E)
    static boolean DFS(ArrayList<ArrayList<Integer>> adj,int v){
        boolean visited[]=new boolean[v+1];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(DFSRec(adj,i,visited,-1)==true) 
                    return true;
            }
        }
        return false;
    }
}
