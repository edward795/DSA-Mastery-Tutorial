package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTreePlm {
    public static void main(String[] args) {
        int[][] edges=new int[][]{{0,1,5},{1,0,5},{0,2,1},{2,0,1},{1,2,3},{2,1,3}};
        System.out.println("Minimum Spanning Tree : "+spanningTree(3, 3, edges));
    }

    public static int spanningTree(int V,int E,int edges[][]){
        ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            int wt=i[2];

            adj.get(u).add(new Edge(u,v,wt));
            adj.get(v).add(new Edge(v,u,wt));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        boolean[] visited=new boolean[V];

        int count=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            count+=p.wt;
            for(Edge e:adj.get(p.v)){
                if(!visited[p.v]){
                    pq.add(new Pair(e.dst,e.wt));
                }
            }
        }

        return count;
    }
}

class Edge{
    int src,dst,wt;

    Edge(int src,int dst,int wt){
        this.src=src;
        this.dst=dst;
        this.wt=wt;
    }
}

class Pair implements Comparable<Pair>{
    int v,wt;

    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }

    @Override
    public int compareTo(Pair p){
        return this.wt-p.wt;
    }
}