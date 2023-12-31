package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class TarjansAlgorithm {
    static int time=0;
    static ArrayList<ArrayList<Integer>> ans;
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(1,0);
        g.addEdge(2, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        System.out.println("Strongly connected components are : "+tarjans(5, g.adj));
    }

    static void dfs(int s,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int[] low,int[] dist,boolean[] inStack){
        dist[s]=low[s]=time++;
        st.push(s);
        inStack[s]=true;

        for(int u:adj.get(s)){
            if(dist[u]==-1){
                dfs(u,adj,st,dist,low,inStack);
                low[s]=Math.min(low[u],low[s]);
            }else if(inStack[u]){
                low[s]=Math.min(low[s],dist[u]);
            }
        }

        if(low[s]==dist[s]){
            ArrayList<Integer> list=new ArrayList<>();
            while(st.peek()!=s){
                inStack[st.peek()]=false;
                list.add(st.pop());
            }
            inStack[st.peek()]=false;
            list.add(st.pop());
            Collections.sort(list);
            ans.add(list);
        }
    }

    static ArrayList<ArrayList<Integer>> tarjans(int V,ArrayList<ArrayList<Integer>> adj){
        time=0;
        ans=new ArrayList<>();
        int[] disc=new int[V];
        int[] low=new int[V];
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        boolean[] inStack=new boolean[V];
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<V;i++){
            if(disc[i]==1){
                dfs(i,adj,st,disc,low,inStack);
            }
        }

        Collections.sort(ans,(a,b)->a.get(0)-b.get(0));
        return ans;
    }
}
