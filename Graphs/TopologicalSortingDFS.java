package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortingDFS {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        topoSort(g.adj, 5);
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited,Stack<Integer> st){
        visited[s]=true;
        for(int u:adj.get(s)){
            if(!visited[u]){
                dfs(adj,u,visited,st);
                visited[u]=true;
            }
        }

        st.push(s);
    }

    //TC : O(V+E)
    static void topoSort(ArrayList<ArrayList<Integer>> adj,int v){
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(adj, i, visited, st);
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
}
