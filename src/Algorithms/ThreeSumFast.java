package Algorithms;

import java.util.Arrays;

public class ThreeSumFast {
    public static void main(String[] args) {
        int[] arr = {-5, 4, 1, -7, 8, -10, 2, 3, -9, 5, 6, 7, 9, -3, -11, 11, -12, 12, -1, -2, -4};
        int n = arr.length;
        Arrays.sort(arr);
        if (containsDuplicate(arr)) throw new IllegalArgumentException("duplicate in array");
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
                if (k > j) {
                    System.out.printf("sum of %d,  %d and %d is 0%n", arr[i], arr[j], arr[k]);
                }
            }
        }
    }

    private static boolean containsDuplicate(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
