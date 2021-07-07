package Algorithms;

import java.util.Arrays;

public class Sattolo {
    /**
     * Rearranges an array of objects to be a uniformly random cycle
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     *
     * @param a the array to be rearranged
     */
    public Sattolo() {
    }

    public static void main(String[] args) {
        String[] st = {"d", "q", "y", "z", "o", "n", "e", "i", "m"};
        cycle(st);
        System.out.println(Arrays.toString(st));
    }

    private static void cycle(Object[] st) {
        for (int i = st.length; i > 1; i--) {
            int rnd = (int) (Math.random() * (i - 1));
            Object swap = st[rnd];
            st[rnd] = st[i - 1];
            st[i - 1] = swap;
        }
    }
}
