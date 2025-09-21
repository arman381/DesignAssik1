package algorithms;

public class MergeSort {
    public static long comparisons = 0;
    public static long assignments = 0;

    public static void mergeSort(int[] arr) {
        comparisons = 0;
        assignments = 0;
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
            assignments++;
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
            assignments++;
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                assignments++;
                i++;
            } else {
                arr[k] = rightArr[j];
                assignments++;
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            assignments++;
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            assignments++;
            j++;
            k++;
        }
    }
}