package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsMinimumSpanningTree {
    public static void main(String[] args) {
        int[][] edges=new int[][]{{0,1,5},
            {1,2,3},
            {0,2,1}};
    
        System.out.println(spanningTree(3, 3, edges));
    } 


static int spanningTree(int V,int E,int edges[][]){
    ArrayList<ArrayList<Edge>> adj=new ArrayList<>();
    for(int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }

    for(int[] i:edges){
        int u=i[0];
        int v=i[1];
        int w=i[2];
        adj.get(u).add(new Edge(u, v, w));
        adj.get(v).add(new Edge(v, u, w));
    }

    PriorityQueue<Pair> pq=new PriorityQueue<>();
    pq.add(new Pair(0,0));
    boolean[] visited=new boolean[V];
    int count=0;
    while(!pq.isEmpty()){
        Pair p=pq.poll();
        count+=p.w;

        for(Edge e:adj.get(p.v)){
            if(!visited[p.v]){
                visited[p.v]=true;
                pq.add(new Pair(e.dst,e.wt));
            };
        }
    }
    return count;
}
}

class Pair implements Comparable<Pair>{
    int v,w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }

    public int compareTo(Pair p2){
        return this.w-p2.w;
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