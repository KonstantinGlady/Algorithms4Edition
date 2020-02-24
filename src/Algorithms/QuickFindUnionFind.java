package Algorithms;

public class QuickFindUnionFind {
    private int[] id;
    private int count;

    public QuickFindUnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) throw new IllegalArgumentException(p + " less then 0 or more then" + (n - 1));
    }

    private int find(int p) {
        validate(p);
        return id[p];
    }

    private boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    private void union(int p, int q) {
        validate(p);
        validate(q);
        int idP = id[p];
        int idQ = id[q];
        if (idP == idQ) {return;}
        for (int i = 0; i < id.length; i++) {
            if (idP == id[i]) {
                id[i] = idQ;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        int[][]arr = {
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
        QuickFindUnionFind qUF = new QuickFindUnionFind(10);
        for (int i = 0; i < arr.length ; i++) {
            int p = arr[i][0];
            int q = arr[i][1];
            if (qUF.find(p) != qUF.find(q)) {
                qUF.union(p, q);
                System.out.printf("%d connected to %d%n",p,q);
            } else {
                System.out.printf("%d not connected to %d%n",p,q);
            }
        }
        System.out.println(qUF.count + " elements");
    }
}
