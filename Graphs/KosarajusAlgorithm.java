package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgorithm {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 2);

        System.out.println("No of strongly connected components : "+kosarajusAlgo(5,g.adj));
    }

    static void dfs1(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st){
        visited[s]=true;
        for(int u:adj.get(s)){
            if(!visited[u]){
                visited[u]=true;
                dfs1(u,adj,visited,st);
            }
        }
        st.push(s);
    }

    static void dfs2(int s,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[s]=true;
        for(int u:adj.get(s)){
            visited[u]=true;
            dfs2(u,adj,visited);
        }
    }

    static int kosarajusAlgo(int V,ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> st=new Stack<Integer>(); 
        boolean[] visited=new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs1(i,adj,visited,st);
            }
        }

        ArrayList<ArrayList<Integer>> trans=new ArrayList<>();
        for(int i=0;i<V;i++){
            visited[i]=false;
            trans.add(new ArrayList<>());
            for(int neigh:adj.get(i)){
                trans.get(neigh).add(i);
            }
        }

        int count=0;
        while(!st.isEmpty()){
            int x=st.pop();
            if(!visited[x]){
                dfs2(x,trans,visited);
                count++;
            }
        }
        return count;
    }
    
}
