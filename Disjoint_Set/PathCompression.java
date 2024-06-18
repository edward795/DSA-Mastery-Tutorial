class PathCompression {

    static int[] parent = new int[5];
    static int[] rank = new int[5];

    public static void main(String[] args) {

    }

    static void initialize() {
        for (int i = 0; i < 5; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // find() with path compression : TC : O(1)
    static int find(int x) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // union() by rank : TC : O(logn)
    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);

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