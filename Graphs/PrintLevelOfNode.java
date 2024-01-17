import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOfNode {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(0,2);
        g.addEdge(2,5);

        System.out.println(printLevel6,g.adj,4);
    }

    static int printLevel(int V,ArrayList<ArrayList<Integer>> adj,int x){
        Queue<Pair> q=new LinkedList<>();
        boolean[] visited=new boolean[V];
        q.add(new Pair(0,0));

        while(!q.isEmpty()){
            Pair p=q.poll();
            if(p.node==x) return p.level;
            for(int i:adj.get(p.node)){
                if(!visited[i]){
                    q.add(new Pair(i,p.level+1));
                }
            }
        }
        return -1;
    }
}

class Pair{
    int level,node;

    Pair(int level,int node){
        this.level=level;
        this.node=node;
    }
}
