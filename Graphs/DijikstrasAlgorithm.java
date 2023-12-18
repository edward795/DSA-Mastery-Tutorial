package Graphs;

public class DijikstrasAlgorithm {
    static int V=9;
    public static void main(String[] args) {
        int graph[][]
            = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        dijikstras(graph, V);
    }
    static int minDistance(int[] dist,Boolean[] spSet){
        int min=Integer.MAX_VALUE,min_index=-1;
        for(int v=0;v<V;v++){
            if(spSet[v]==false && dist[v]<=min){
                min=dist[v];
                min_index=v;
            }
        }
        return min_index;
    }

    static void dijikstras(int[][] graph,int src){
        int[] dist=new int[V];
        Boolean spSet[]=new Boolean[V];

        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
            spSet[i]=false;
        }

        dist[src]=0;
        for(int count=0;count<V-1;count++){
            int u=minDistance(dist, spSet);
            spSet[u]=true;

            for(int v=0;v<V;v++){
                if(!spSet[v] &&  graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]){
                    dist[v]=dist[u]+graph[u][v];
                }
            }
        }

        for(int i:dist)
            System.out.print(i+" ");
    }
}
