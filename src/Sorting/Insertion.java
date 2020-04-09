package Sorting;

public class Insertion {
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && (less(a[j], a[j - 1])); j--) {
                exch(a, j, j - 1);
            }
        }
        assert isSorted(a);
    }

    private boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    private boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int j = lo + 1; j < hi; j++) {
            if (less(a[j], a[j - 1])) {
                return false;
            }
        }
        return true;

    }

    private void exch(Object[] a, int v, int w) {
        Object swap = a[v];
        a[v] = a[w];
        a[w] = swap;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    public void show(Comparable[]a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Comparable[] a = {1, 4, 6, 2, 9, 3, 54, 23, 75, 11, 24, 76,};
        Insertion insertion = new Insertion();
        insertion.sort(a);
        insertion.show(a);

    }
}
