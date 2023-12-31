package Graphs;

import java.util.Collections;

public class KruskalsAlgorithm {
    static int v=5;
    static int[] parent=new int[v];
    static int[] rank=new int[v];
    public static void main(String[] args) {
        Edge[] e=new Edge[5];
        e[0]=new Edge(0,1,8);
        e[1]=new Edge(0,3,10);
        e[2]=new Edge(3,2,3);
        e[3]=new Edge(2,4,15);
        e[4]=new Edge(1,4 , 12);
        System.out.println("Weight of minimum spanning tree is "+kruskals(e));
    }

    static int kruskals(Edge arr[]){
        Collections.sort(arr);
        for(int i=0;i<v;i++){
            parent[i]=i;
            rank[i]=0;
        }

        int res=0;
        for(int i=0,s=0;s<v-1;i++){
            Edge e=arr[i];
            int x=find(e.src);
            int y=find(e.dest);

            if(x!=y){
                res+=e.wt;
                union(x,y);
                s++;
            }
        }
        return res;
    }

    static void union(int x,int y){
        int x_rep=find(x);
        int y_rep=find(y);
        if(x_rep==y_rep) return;
        
        if(rank[x_rep]<rank[y_rep])
            parent[x_rep]=y_rep;
        else if(rank[y_rep]<rank[x_rep])
            parent[y_rep]=x_rep;
        else{
            parent[y_rep]=x_rep;
            rank[x_rep]++;
        }
    }


    static int find(int x){
        if(x==parent[x]){
            return x;
        }
        parent[x]=find(parent[x]);
        return parent[x];
    }

}

class Edge implements Comparable<Edge>{
    int src,dest,wt;
    Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }

    public int compareTo(Edge e){
        return this.wt-e.wt;
    }
}
