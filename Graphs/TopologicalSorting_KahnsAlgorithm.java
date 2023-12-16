package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting_KahnsAlgorithm {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        
        for(int i:topologicalSorting(g.adj, 5))
            System.out.print(i+" ");
    }

    //TC : O(V+E)
    static int[] topologicalSorting(ArrayList<ArrayList<Integer>> adj,int v){
        Queue<Integer> q=new LinkedList<Integer>();
        int[] res=new int[v];
        int[] indegree=new int[v];

        for(int i=0;i<v;i++){
            for(int u:adj.get(i)){
                indegree[u]++;
            }
        }

        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.add(i);
        }

        int k=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[k++]=curr;
            System.out.print(curr+" ");
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0) 
                    q.add(i);
            }
        }
        return res;
    }
}
