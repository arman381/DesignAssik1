package algorithms;

import java.util.Random;

public class QuickSort {
    private static final Random RAND = new Random();

    public static long comparisons = 0;
    public static long swaps = 0;
    public static int maxDepth = 0;

    public static void quickSort(int[] arr) {
        comparisons = 0;
        swaps = 0;
        maxDepth = 0;
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1, 1);
    }

    private static void quickSort(int[] arr, int low, int high, int depth) {
        while (low < high) {
            maxDepth = Math.max(maxDepth, depth);

            int pivotIndex = partition(arr, low, high);

            if (pivotIndex - low < high - pivotIndex) {
                quickSort(arr, low, pivotIndex - 1, depth + 1);
                low = pivotIndex + 1;
            } else {
                quickSort(arr, pivotIndex + 1, high, depth + 1);
                high = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int randomIndex = low + RAND.nextInt(high - low + 1);
        int pivot = arr[randomIndex];
        swap(arr, randomIndex, high);

        int i = low;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swaps++;
    }
}