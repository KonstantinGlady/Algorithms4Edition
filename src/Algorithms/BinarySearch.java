package Algorithms;

import java.util.Arrays;


public class BinarySearch {

    private BinarySearch() { }
    /**
     * Returns the index of the specified key in the specified array.
     *
     * //@param  arr the array of integers, must be sorted in ascending order
     * //@param  key the search key
     * @return index of key in array {@code a} if present; {@code -1} otherwise
     */
    public static void main(String[] args) {
        int key = 5;
        int[] arr = {2, 4, 1, 6, 7, 3, 9, 4, 6, 3, 5, 6};

        Arrays.sort(arr);
        System.out.println(indexOf(arr, key));
    }

    public static int indexOf(int[] arr, int key) {
        int hi = arr.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
