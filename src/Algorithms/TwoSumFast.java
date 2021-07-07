package Algorithms;

import java.util.Arrays;

public class TwoSumFast {
    public static void main(String[] args) {
        int[] arr = {-5, 4, 1, -7, 8, -10, 2, 3, -9, 5, 6, 7, 9};
        Arrays.sort(arr);
        if (duplicateInt(arr)) throw new IllegalArgumentException("double in array");
        for (int i = 0; i < arr.length; i++) {
            int j = Arrays.binarySearch(arr, -arr[i]);
            if (j > i) {
                System.out.printf("sum %d + %d = 0%n ", arr[j], arr[i]);
            }
        }

    }

    private static boolean duplicateInt(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
