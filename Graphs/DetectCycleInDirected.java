package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirected {
    public static void main(String[] args) {
        int v=5;
        Graph g=new Graph(v);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.addEdge(1, 4);
        System.out.println("Is the graph cyclic : "+isCyclic(g.adj,v));
    }

    //TC : O(V+E)
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj,int v){
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[v];
        for(int i=0;i<v;i++){
            for(int u:adj.get(i)){
                indegree[u]++;
            }
        }
        int count=0;

        for(int i=0;i<v;i++){
            if(indegree[i]==0) 
                q.add(i);
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
            count++;
        }
        return (count!=v);
    }
}
