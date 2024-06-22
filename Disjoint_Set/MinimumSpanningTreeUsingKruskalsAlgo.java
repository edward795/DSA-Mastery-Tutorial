import java.util.PriorityQueue;

public class MinimumSpanningTreeUsingKruskalsAlgo {
    public static void main(String[] args) {
        Edge[] edges = new Edge[] { new Edge(1, 2, 4), new Edge(1, 3, 3), new Edge(2, 4, 1), new Edge(2, 5, 1),
                new Edge(4, 5, 3), new Edge(3, 4, 2) };
        int n = 5, m = 6;
        System.out.println("Minimum spanning tree using kruskal's & DSU is " + kruskalsDSU(edges, n, m));
    }

    // TC : O(N+M)
    static int kruskalsDSU(Edge[] edges, int n, int m) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((n1, n2) -> (n1.wt - n2.wt));
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < m; i++) {
            pq.add(edges[i]);
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int res = 0;
        for (int i = 0, s = 0; s < n - 1 && !pq.isEmpty(); i++) {
            Edge e = pq.poll();
            int x = find(e.u, parent);
            int y = find(e.v, parent);
            if (x != y) {
                res += e.wt;
                union(x, y, parent, rank);
                union(x, y, parent, rank);
                s++;
            }
        }
        return res;
    }

    static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return find(parent[x], parent);
    }

    static void union(int x, int y, int[] parent, int[] rank) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (rank[x_rep] < rank[y_rep]) {
            parent[x_rep] = y_rep;
        } else if (rank[y_rep] < rank[x_rep]) {
            parent[y_rep] = x_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}

class Edge {
    int v, u, wt;

    Edge(int v, int u, int wt) {
        this.v = v;
        this.u = u;
        this.wt = wt;
    }
}