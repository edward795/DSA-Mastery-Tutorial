import java.util.ArrayList;
import java.util.HashSet;

public class NoOfConnectedComponents {
    public static void main(String[] args) {
        int[] parent = new int[6];
        int[] rank = new int[6];
        for (int i = 0; i < 6; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(1, 3, adj);
        addEdge(1, 4, adj);

        for (int i = 0; i < 6; i++) {
            for (int j : adj.get(i)) {
                union(j, i, rank, parent);
            }
        }

        System.out.println("The no: of connected components : " + findNoOfConnectedComponents(5, parent, rank));
    }

    static void addEdge(int v, int u, ArrayList<ArrayList<Integer>> adj) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return find(parent[x], parent);
    }

    static void union(int x, int y, int[] rank, int[] parent) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (x_rep == y_rep)
            return;
        parent[y_rep] = x_rep;
    }

    static int findNoOfConnectedComponents(int n, int[] parent, int[] rank) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            hs.add(find(i, parent));
        }
        return hs.size();
    }
}
