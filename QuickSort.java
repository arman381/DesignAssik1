package algorithms;

import java.util.Random;

public class QuickSort {
    private static final Random RAND = new Random(42);

    public static long comparisons = 0;
    public static long assignments = 0;
    public static int maxDepth = 0;

    public static void quickSort(int[] arr) {
        comparisons = 0;
        assignments = 0;
        maxDepth = 0;
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1, 1);
    }

    private static void quickSort(int[] a, int left, int right, int depth) {
        while (left < right) {
            maxDepth = Math.max(maxDepth, depth);
            int pivotIndex = randomizedPartition(a, left, right);
            int leftSize = pivotIndex - left;
            int rightSize = right - pivotIndex;


            if (leftSize < rightSize) {
                if (left < pivotIndex - 1) quickSort(a, left, pivotIndex - 1, depth + 1);
                left = pivotIndex + 1;
            } else {
                if (pivotIndex + 1 < right) quickSort(a, pivotIndex + 1, right, depth + 1);
                right = pivotIndex - 1;
            }
        }
    }

    private static int randomizedPartition(int[] a, int left, int right) {
        int randIndex = left + RAND.nextInt(right - left + 1);
        swap(a, randIndex, right);
        return partition(a, left, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        assignments++;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            comparisons++;
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        assignments += 3;
    }
}