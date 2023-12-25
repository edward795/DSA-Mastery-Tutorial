package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijikstrasAlgoUsingPQ {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(1, 1);
        g.addEdge(2, 6);
        g.addEdge(2, 3);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(0, 6);
        
        for(int i:dijikstras(6, g.adj, 0))
            System.out.print(i+" ");
    }

    static int[] dijikstras(int V,ArrayList<ArrayList<Integer>> adj,int s){
        boolean[] visited=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.w-b.w));
        int[] res=new int[V];
        Arrays.fill(res,Integer.MAX_VALUE);
        pq.offer(new Pair(s,0));
        res[s]=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            visited[p.v]=true;
            for(ArrayList<Integer> i:adj.get(p.v)){
                int next=i.get(0);
                int d=i.get(1);
                if(res[next]>p.w+d && !visited[next]){
                    res[next]=p.w+d;
                    pq.offer(new Pair(next,res[next]));
                }    
            }
        }
        return res;
    }
}

class Pair implements Comparable<Pair>{
    int v,w;

    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }

    public int compareTo(Pair p){
        return this.w-p.w;
    }
}