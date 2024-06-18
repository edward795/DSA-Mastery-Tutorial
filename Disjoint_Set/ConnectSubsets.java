
class ConnectSubSets {

    public static void main(String[] args) {
        /**
         * union(1,3) isConnected(1,2) union(1,5) isConnected(3,5)
         */
        int n = 6;
        int q = 4;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        union(1, 3, parent, rank);
        System.out.println("Are the components 1 & 2 connected : " + isConnected(1, 2, parent));
        union(1, 5, parent, rank);
        System.out.println("Are the components 1 & 5 connected : " + isConnected(3, 5, parent));
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

    static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        parent[x] = find(parent[x], parent);
        return parent[x];
    }

    static boolean isConnected(int x, int y, int[] parent) {
        int x_rep = find(x, parent);
        int y_rep = find(y, parent);
        if (x_rep == y_rep)
            return true;
        return false;
    }

}