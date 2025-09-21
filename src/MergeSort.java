import java.util.Arrays;

public class MergeSort {
    public static class Metrics {
        public long comparisons = 0;
        public int maxDepth = 0;
    }

    public static void sort(int[] arr, Metrics m) {
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1, m, 1);
    }

    private static void mergeSort(int[] arr, int[] buffer, int left, int right, Metrics m, int depth) {
        m.maxDepth = Math.max(m.maxDepth, depth);

        if (right - left + 1 <= 16) { // cutoff
            insertionSort(arr, left, right, m);
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, buffer, left, mid, m, depth + 1);
        mergeSort(arr, buffer, mid + 1, right, m, depth + 1);
        merge(arr, buffer, left, mid, right, m);
    }

    private static void merge(int[] arr, int[] buffer, int left, int mid, int right, Metrics m) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            m.comparisons++;
            if (arr[i] <= arr[j]) buffer[k++] = arr[i++];
            else buffer[k++] = arr[j++];
        }

        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= right) buffer[k++] = arr[j++];

        for (i = left; i <= right; i++) arr[i] = buffer[i];
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics m) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left) {
                m.comparisons++;
                if (arr[j] <= key) break;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

//test
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        Metrics m = new Metrics();
        sort(arr, m);
        System.out.println(Arrays.toString(arr));
        System.out.println("Comparisons: " + m.comparisons + ", MaxDepth: " + m.maxDepth);
    }
}
