package Algorithms;

public class Backpack {

    /**
     * @param weight - массив значений веса предметов
     * @param val    - массив значений ценности предметов
     * @param w      - максимально допустимый вес вещей в рюкзаке
     * @param n      - элемент, который мы хотим положить на текущей итерации
     * @return максимально возможная ценность предметов, которые могут поместиться в рюкзаке
     */
    public static int recursive(int[] weight, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (weight[n - 1] > w) {
            return recursive(weight, val, w, n - 1);
        } else {
            return max(val[n - 1] + recursive(weight, val, w - weight[n - 1], n - 1),
                    recursive(weight, val, w, n - 1)
            );
        }
    }

    private static int max(int a, int b) {
        return (Math.max(a, b)); // return ((a > b) ? a : b);
    }

    public static void main(String[] args) {
        int[] weight = {2, 3, 3, 4};
        int[] val = {1, 2, 5, 9};
        int w = 7;
        int n = val.length;

        System.out.println(recursive(weight, val, w, n));
    }
}
