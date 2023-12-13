package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGraph {
    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0,2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        shortestPath(g.adj, 4, 0);
    }

    //TC : O(V+E)
    static void shortestPath(ArrayList<ArrayList<Integer>> adj,int v,int s){
        Queue<Integer> q=new LinkedList<>();
        int[] dist=new int[v];
        boolean visited[]=new boolean[v];
        q.add(s);
        visited[s]=true;

        while(!q.isEmpty()){
            int u=q.poll();
            for(int i:adj.get(u)){
                if(!visited[i]){
                    dist[i]=dist[u]+1;
                    q.add(i);
                    visited[i]=true;
                }
            }
        }

        for(Integer i:dist)
            System.out.print(i+" ");
    }
}
