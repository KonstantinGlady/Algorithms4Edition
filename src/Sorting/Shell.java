package Sorting;

public class Shell {
    public Shell() {
    }

    public static void main(String[] args) {
       // Comparable[] a = {1, 4, 6, 2, 9, 3, 54, 23, 75, 11, 24};
        Comparable[] a = { 'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'};
        Shell.sort(a);
        Shell.show(a);
    }


    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void excha(Object[] a, int v, int w) {
        Object swap = a[v];
        a[v] = a[w];
        a[w] = swap;
    }


    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    excha(a, j, j - n);
                }
            }
            h /= 3;
        }
    }
}
