package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortMetricsTest {

    @Test
    void testMergeSortCorrectness() {
        int[] arr = {4, 3, 2, 1};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr, "The array is not sorted correctly!");
    }

    @Test
    void testMergeSortMetrics() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        MergeSort.mergeSort(arr);

        assertTrue(MergeSort.comparisons > 0, "Comparisons should be greater than 0");
        assertTrue(MergeSort.assignments > 0, "Assignments should be greater than 0");
    }
}