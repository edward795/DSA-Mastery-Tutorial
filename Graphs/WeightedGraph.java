package Graphs;
import java.util.LinkedList;



public class WeightedGraph {
    int v;
    static LinkedList<WeightedNode> adj[];

    WeightedGraph(int v){
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<WeightedNode>();
        }
    }

    static void addEdge(int u,int v,int w){
        WeightedNode node =new WeightedNode(v, w);
        adj[u].add(node);
    }
}

class WeightedNode{
    int v,w;
    WeightedNode(int v,int w){
        v=this.v;
        w=this.w;
    }
    public int getV() {
        return v;
    }
    public int getW() {
        return w;
    }
}
