package Algorithms;

public class WeightedQuickUnionUF {
    int[] parent;
    int[] size;
    int count;

    public WeightedQuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
    public int count(){
        return count;
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
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        for (int i = 0; i < arr.length; i++) {
            int p = arr[i][0];
            int q = arr[i][1];
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
                System.out.printf("%d connected %d%n", p, q);
            } else {
                System.out.printf("%d not connected %d%n", p, q);

            }
        }
        System.out.println(uf.count+ " segments");
    }
}
