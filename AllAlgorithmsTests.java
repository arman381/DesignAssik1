package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AllAlgorithmsTests {

    @Test
    void testMergeSort() {
        int[] arr = {4, 3, 2, 1};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr, "MergeSort is incorrect!");
    }

    @Test
    void testQuickSort() {
        int[] arr = {4, 3, 2, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr, "QuickSort is incorrect!");
    }

    @Test
    void testDeterministicSelect() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int k = 3;
        int result = DeterministicSelect.select(arr, k);
        assertEquals(7, result, "DeterministicSelect is incorrect!");
    }

    @Test
    void testClosestPair() {
        ClosestPair.Point[] points = {new ClosestPair.Point(0, 0), new ClosestPair.Point(1, 1), new ClosestPair.Point(2, 2), new ClosestPair.Point(3, 3)};
        double result = ClosestPair.findClosestPair(points);
        assertEquals(1.414, result, 0.001, "ClosestPair is incorrect!");
    }

    @Test
    void testMetrics() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        MergeSort.mergeSort(arr);
        assertTrue(MergeSort.comparisons > 0, "MergeSort Comparisons should be > 0");

        QuickSort.quickSort(arr);
        assertTrue(QuickSort.comparisons > 0, "QuickSort Comparisons should be > 0");

        int k = 3;
        DeterministicSelect.select(arr, k);
        assertTrue(DeterministicSelect.comparisons > 0, "DeterministicSelect Comparisons should be > 0");

        ClosestPair.Point[] points = {new ClosestPair.Point(0, 0), new ClosestPair.Point(1, 1), new ClosestPair.Point(2, 2), new ClosestPair.Point(3, 3)};
        ClosestPair.findClosestPair(points);
        assertTrue(ClosestPair.comparisons > 0, "ClosestPair Comparisons should be > 0");
    }
}