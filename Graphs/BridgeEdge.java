package Graphs;

import java.util.ArrayList;

public class BridgeEdge {

    static int time=0;
    public static void main(String[] args) {
        Graph g=new Graph(3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        System.out.println("Does the edge formed by 1 - 2 form a Bridge edge ? "+isBridge(4,g.adj,1,2));
    }

    static void dfs(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int parent,int[] low,int[] disc,int[] ans,int c,int d){
        visited[s]=true;
        disc[s]=low[s]=time++;

        for(int u:adj.get(s)){
            if(u==parent) continue;
            if(!visited[u]){
                low[s]=Math.min(low[s],low[u]);
                if(low[u]>disc[s] && (u==c && s==d) || (s==c && u==d)){
                    ans[0]=1;
                }else{
                    low[s]=Math.min(low[s],disc[u]);
                }
            }
        }
    }

    static int isBridge(int V,ArrayList<ArrayList<Integer>> adj,int c,int d){
        int[] low=new int[V];
        int[] disc=new int[V];
        int[] ans=new int[]{0};
        boolean[] visited=new boolean[V];
        int parent=-1;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i, adj, visited, parent, low, disc, ans, c, d);
            }
        }
        return ans[0];
    }
}
