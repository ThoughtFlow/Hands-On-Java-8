package Part4;

import java.util.ArrayList;

/**
 * Created by Nick Maiorano.
 */
public class QuickSortImperative {

    public static ArrayList<Integer> imperativeQuickSort(ArrayList<Integer> array, int low, int n) {
        int lo = low;
        int hi = n;

        if (lo >= n) return array;

        // Step 1: find pivot point
        int mid = array.get((lo + hi) / 2);

        // Step 2: find & swap values less & greater than pivot
        while (lo < hi) {
            while (lo < hi && array.get(lo) < mid) {
                lo++;
            }
            while (lo < hi && array.get(hi) > mid) {
                hi--;
            }
            if (lo < hi) {
                // Swap values
                int temp = array.get(lo);
                array.set(lo, array.get(hi));
                array.set(hi, temp);
                lo++;
                hi--;
            }
        }

        if (hi < lo) lo = hi;

        // Steps 3: split the array and repeat recursively
        imperativeQuickSort(array, low, lo);
        imperativeQuickSort(array, lo == low ? lo + 1 : lo, n);

        return array;
    }

    public static ArrayList<Integer> imperativeQuickSort(ArrayList<Integer> array)
    {
        return imperativeQuickSort(array, 0, array.size());
    }
}
