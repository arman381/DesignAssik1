package algorithms;

import java.util.Random;

public class QuickSort {
    private static final Random RAND = new Random();


    public static long comparisons = 0, swaps = 0;
    public static int maxDepth = 0;

    public static void quickSort(int[] a) {
        comparisons = swaps = 0; maxDepth = 0;
        if (a == null || a.length <= 1) return;
        quickSort(a, 0, a.length - 1, 1);
    }

    private static void quickSort(int[] a, int lo, int hi, int depth) {
        while (lo < hi) {
            maxDepth = Math.max(maxDepth, depth);

            int p = partition(a, lo, hi);
            if (p - lo < hi - p) {
                quickSort(a, lo, p - 1, depth + 1);
                lo = p + 1;
            } else {
                quickSort(a, p + 1, hi, depth + 1);
                hi = p - 1;
            }
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pv = lo + RAND.nextInt(hi - lo + 1);
        int pivot = a[pv];
        swap(a, pv, hi);

        int i = lo;
        for (int j = lo; j < hi; j++) {
            comparisons++;
            if (a[j] < pivot) swap(a, i++, j);
        }
        swap(a, i, hi);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int t = a[i]; a[i] = a[j]; a[j] = t;
        swaps++;
    }
}