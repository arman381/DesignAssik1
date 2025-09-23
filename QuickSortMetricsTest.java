package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuickSortMetricsTest {

    @Test
    void testQuickSortCorrectness() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr, "The array is not sorted correctly!");
    }

    @Test
    void testQuickSortMetrics() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(arr);

        assertTrue(QuickSort.comparisons > 0, "Comparisons should be greater than 0");
        assertTrue(QuickSort.assignments > 0, "Assignments should be greater than 0");
        assertTrue(QuickSort.maxDepth > 0, "Max depth should be greater than 0");
    }
}