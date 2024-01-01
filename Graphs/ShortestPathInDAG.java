package Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class ShortestPathInDAG {
      static Stack<Integer> st=new Stack<>();
    public static void main(String[] args) {
        WeightedGraph g=new WeightedGraph(6);
        g.addEdge(0, 1,2);
        g.addEdge(1, 2,3);
        g.addEdge(2, 3,6);
        g.addEdge(0, 4,1);
        g.addEdge(4, 5,4);
        g.addEdge(5, 3,1);
        g.addEdge(4, 2,2);

        for(int i:shortestPath(g.adj, 6, 0))
            System.out.print(i+" ");
    }

    static int[] shortestPath(LinkedList<WeightedNode> adj[],int v,int s){
        topSort(adj, v);
        int[] dist=new int[v];
        for(int i=0;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        dist[0]=0;
        while(!st.isEmpty()){
            int u=st.pop();
            Iterator<WeightedNode> it;
            if(dist[u]!=Integer.MAX_VALUE){
                it=adj[u].iterator();
                while(it.hasNext()){
                    WeightedNode i=it.next();
                    if(dist[i.getV()]>dist[u]+i.getW()){
                        dist[i.getV()]=dist[u]+i.getW();
                    }
                }
            }
        }
        return dist;
    }

    static void topSort(LinkedList<WeightedNode> adj[],int v){
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(adj,i,visited);
            }
        }
    }
    
    static void dfs(LinkedList<WeightedNode> adj[],int s,boolean[] visited){
       visited[s]=true;
       for(WeightedNode u:adj[s]){
            if(!visited[u.v]){
                visited[u.v]=true;
                dfs(adj,u.v,visited);
            }
       } 

       st.push(s);
    }
}
