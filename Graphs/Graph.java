package Graphs;

import java.util.ArrayList;

public class Graph {
    public static ArrayList<ArrayList<Integer>> adj;

    public static void addEdge(int i,int j){
        adj.get(i).add(j);
        adj.get(j).add(i);
    }

    Graph(int v){
        adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
    }


    static ArrayList<ArrayList<Integer>> getConnectedGraph(){
        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,5);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);
        return adj;
    }

    static ArrayList<ArrayList<Integer>> getDisconnectedGraph(){
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(5, 6);
        return adj;
    }
    
}
