import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountPaths {
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        // System.out.println("Result : "+countPaths(5,g.adj,0,4));
    }

    // public int countPaths(int V,ArrayList<ArrayList<Integer>> adj,int source,int destination){
    //     boolean[] visited=new boolean[V];
    //     int res=0;
    //     dfs(adj, source, destination, visited, res);
    //     return res;
    // }

    // public static void dfs(ArrayList<ArrayList<Integer>> adj,int source,int destination,boolean[] visited,int res){
    //     visited[source]=true;
    //     if(source==destination){
    //         res++;
    //         return;
    //     }

    //     for(int u:adj.get(source)){
    //         if(!visited[u]){
    //             dfs(adj,u,destination,visited,res);
    //             visited[u]=true;
    //         }
    //     }
    // }

    // public int countPaths(int V,ArrayList<ArrayList<Integer>> adj,int source,int destination){
    //     return dfs(source,adj,destination);
    // }

    // public int dfs(int s,ArrayList<ArrayList<Integer>> adj,int dest){
    //     if(s==dest) return 1;
    //     int count=0;
    //     for(int i:adj.get(s)){
    //         count+=dfs(i,adj,dest);
    //     }
    //     return count;
    // }

    // BFS based Solution
    public int countPaths(int V,ArrayList<ArrayList<Integer>> adj,int source,int destination){
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==destination) count++;
            for(int u:adj.get(curr)){
                q.add(u);
            }
        }
        return count;
    }
}
