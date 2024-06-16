package Disjoint_Set;

class DisjointSet {
    static int n = 5;
    static int[] parent = new int[n];

    public static void main(String[] args) {
        initialize();
        System.out.println("The representative integer of set 1 & 2 is " + find(1) + " " + find(2));
        union(1, 2);
        System.out.println("The representative integer of set 1 & 2 is " + find(1) + " " + find(2));
    }

    static void initialize() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);
    }

    static void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep)
            return;

        parent[y_rep] = x_rep;
    }
}