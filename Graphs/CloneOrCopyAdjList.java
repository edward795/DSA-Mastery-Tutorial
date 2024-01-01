package Graphs;

import java.util.ArrayList;

public class CloneOrCopyAdjList {
    public static void main(String[] args) {
        Graph g=new Graph(6);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
        // System.out.println(cloneGraph(g.adj));    
        System.out.println(printGraph(6, g.adj));
    }

    
    // static ArrayList<ArrayList<Integer>> cloneGraph(ArrayList<ArrayList<Integer>> adj){
    //     ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    //     System.out.println(adj);
    //     for(int i=0;i<adj.size();i++){
    //         res.add(new ArrayList<>());
    //     }
    //     for(int i=0;i<adj.size();i++){
    //         for(int u:adj.get(i)){
    //             res.get(i).add(u);
    //         }
    //     }
    //     return res;
    // }

    static ArrayList<ArrayList<Integer>> printGraph(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        for(int i=0;i<adj.size();i++){
            ArrayList<Integer> a=new ArrayList<>(adj.get(i).size());
            //a.add(i);
            for(int j=0;j<adj.get(i).size();j++){
                a.add(adj.get(i).get(j));
            }
            res.add(a);
        }
        return res;
    }
}
