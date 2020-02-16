package Algorithms;

public class UnionFind {
    private int[] parent;
    private byte[] rank;
    private int count;

    public UnionFind(int count) {
        if (count < 0) throw new IllegalArgumentException();
        this.count = count;
        this.parent = new int[count];
        this.rank = new byte[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
    }

    private int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  // path compression by halving
            p = parent[p];
        }
        return p;
    }

    private int count() {
        return count;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {4, 3},
                {3, 8},
                {6, 5},
                {9, 4},
                {2, 1},
                {8, 9},
                {5, 0},
                {7, 2},
                {6, 1},
                {1, 0},
                {6, 7},
        };
        UnionFind uf = new UnionFind(10);
        for (int i = 0; i < arr.length; i++) {
            int p = arr[i][0];
            int q = arr[i][1];

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.printf(" %d  %d connected%n ", p, q);
            } else {
                System.out.printf(" %d  %d not connected%n ", p, q);
            }
        }
        System.out.println(uf.count + " components");
    }


}
