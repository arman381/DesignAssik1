package algorithms;

import java.util.Arrays;

public class DeterministicSelect {
    public static long comparisons = 0;

    public static int select(int[] arr, int k) {
        comparisons = 0;
        if (arr == null || arr.length == 0 || k < 1 || k > arr.length) {
            return -1;
        }
        return select(arr, 0, arr.length - 1, k - 1);
    }

    private static int select(int[] arr, int left, int right, int k) {
        while (true) {
            if (left == right) {
                return arr[left];
            }

            int pivotIndex = medianOfMedians(arr, left, right);
            pivotIndex = partition(arr, left, right, pivotIndex);

            if (k == pivotIndex) {
                return arr[k];
            } else if (k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;

        if (n <= 5) {
            return findMedianIndex(arr, left, right);
        }

        int numGroups = (n + 4) / 5;
        int[] medians = new int[numGroups];

        for (int i = 0; i < numGroups; i++) {
            int groupLeft = left + i * 5;
            int groupRight = Math.min(groupLeft + 4, right);
            medians[i] = findMedianIndex(arr, groupLeft, groupRight);
        }

        return findMedianIndex(medians, 0, medians.length - 1);
    }

    private static int findMedianIndex(int[] arr, int left, int right) {
        int[] subarray = Arrays.copyOfRange(arr, left, right + 1);
        Arrays.sort(subarray);
        comparisons += (long) subarray.length * (subarray.length - 1) / 2;

        int medianValue = subarray[subarray.length / 2];
        for (int i = left; i <= right; i++) {
            if (arr[i] == medianValue) {
                return i;
            }
        }
        return left;
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            comparisons++;
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}