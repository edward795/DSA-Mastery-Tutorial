package Disjoint_Set;

public class UnionByRank {

    static int[] parent = new int[5];
    static int[] rank = new int[5];

    public static void main(String[] args) {
        initialize();
        System.out.println("The representative integer of set 1 & 2 is " + find(1) + " " + find(2));
        union(1, 2);
        System.out.println("The representative integer of set 1 & 2 is " + find(1) + " " + find(2));
    }

    static void initialize() {
        for (int i = 0; i < 5; i++) {
            parent[i] = i;
            rank[i] = 0;
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
