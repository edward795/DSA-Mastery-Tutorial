package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {
    static int time=0;
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge( 1, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        System.out.println(articulationPoint(6,g.adj));
    }

    static void dfs(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int[] parent,int[] low,int[] dist,boolean[] ap){
        visited[s]=true;
        low[s]=dist[s]=time++;
        int children=0;
        for(int u:adj.get(s)){
            if(!visited[u]){
                children++;
                parent[u]=s;
                dfs(u,adj,visited,parent,low,dist,ap);
                low[s]=Math.min(low[s],low[u]);
                if(parent[s]==-1 && children>1){
                    ap[s]=true;
                }
                if(parent[s]!=-1 && low[u]>=dist[s]){
                    ap[s]=true;
                }
            }else if(u!=parent[s]){
                low[s]=Math.min(low[s],dist[u]);
            }
        }
    }

    public static ArrayList<Integer> articulationPoint(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] visited=new boolean[V];
        boolean[] ap=new boolean[V];
        int[] dist=new int[V];
        int[] low=new int[V];
        int[] parent=new int[V];
        Arrays.fill(parent,-1);

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited,parent,low,dist,ap);
            }
        }

        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(ap[i]){
                al.add(i);
            }
        }

        if(al.size()==0){
            al.add(-1);
        }
        return al;
    }
}