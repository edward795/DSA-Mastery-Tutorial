import java.util.ArrayList;

class DetectCycleInDSU {
    static int V = 5;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            arrayList.add(new ArrayList<>());
        }

        addEdge(arrayList, 1, 3);
        addEdge(arrayList, 3, 0);
        addEdge(arrayList, 0, 2);
        addEdge(arrayList, 0, 4);
        addEdge(arrayList, 2, 4);

        System.out.println("Is the graph having a cycle ? " + detectCycleInDSU(V, arrayList));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int v) {
        adj.get(s).add(v);
        adj.get(v).add(s);
    }

    static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return find(parent[x], parent);
    }

    static void union(int x, int y, int[] parent) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (x_rep == y_rep)
            return;
        parent[y_rep] = x_rep;
    }

    // TC : O(V+E)
    static int detectCycleInDSU(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                if (j > i) {
                    if (find(i, parent) == find(j, parent))
                        return 1;
                }
                union(i, j, parent);
            }
        }
        return 0;
    }
}