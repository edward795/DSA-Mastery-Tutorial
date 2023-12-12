package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import LinkedList.utils.LinkedList;

public class BFSWithSource {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        ArrayList<ArrayList<Integer>> adj=g.getConnectedGraph();
        BFSWithSource(adj, 5, 0);
    }

    //TC : O(V + E) - O(V)
    static void BFSWithSource(ArrayList<ArrayList<Integer>> adj,int v,int s){
        boolean visited[]=new boolean[v+1];
        Queue<Integer> q=new ArrayDeque<Integer>();
        visited[s]=true;
        q.add(s);

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
}
