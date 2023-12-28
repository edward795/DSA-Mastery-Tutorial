package Graphs;

public class BellmannFordAlgorithm {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph
 
        Graph graph = new Graph(V, E);
 
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].wt = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].wt = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].wt = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].wt = 2;
 
        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].wt = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].wt = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].wt = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].wt = -3;
         
          // Function call
        int[] dist=graph.BellmanFord(graph, 0);

        for(int i:dist)
            System.out.print(i+" ");
    }
}

class Graph{

    int V,E;
    Edge edge[];

    Graph(int v,int e){
        V=v;
        E=e;
        edge=new Edge[e];
        for(int i=0;i<e;i++){
            edge[i]=new Edge();
        }
    }

    class Edge{
        int src,dest,wt;

        Edge(){
            src=dest=wt=0;
        }
    }

    static int[] BellmanFord(Graph graph,int src){
        int V=graph.V,E=graph.E;
        int[] dist=new int[V];

        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;

        for(int i=1;i<V;i++){
            for(int j=0;j<E;j++){
                int u=graph.edge[j].src;
                int v=graph.edge[j].dest;
                int weight=graph.edge[j].wt;

                if(dist[u]!=Integer.MAX_VALUE && dist[v]+weight<dist[u]){
                    dist[v]=dist[u]+weight;
                }
            }
        }

        for(int j=0;j<E;j++){
            int u=graph.edge[j].src;
            int v=graph.edge[j].src;
            int weight=graph.edge[j].wt;

            if(dist[u]!=Integer.MAX_VALUE && dist[u]+weight<dist[v]){
                System.out.println("Graph contains negative weight edges!");
                return dist;
            }
        }
        return dist;
    }    
}

