package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSWithoutSource {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new Graph(7).getDisconnectedGraph();
        BFSDisc(adj, 7);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj,int v,int s,boolean[] visited){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        visited[s]=true;

        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int i:adj.get(u)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }

    //TC : O(V+E) - O(V)
    static void BFSDisc(ArrayList<ArrayList<Integer>> adj,int v){
        boolean[] visited=new boolean[v+1];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                BFS(adj,v,i,visited);
            }
        }
    }
}
