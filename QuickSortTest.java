package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {
    @Test void testSimpleArray() {
        int[] arr = {5, 2, 9, 1, 6, 3};
        int[] exp = {1, 2, 3, 5, 6, 9};
        QuickSort.quickSort(arr);
        assertArrayEquals(exp, arr);
    }
    @Test void testEmptyArray() {
        int[] arr = {};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
    @Test void testAlreadySorted() {
        int[] arr = {1,2,3,4,5};
        int[] exp = {1,2,3,4,5};
        QuickSort.quickSort(arr);
        assertArrayEquals(exp, arr);
    }
    @Test void testReverseArray() {
        int[] arr = {9,8,7,6,5};
        int[] exp = {5,6,7,8,9};
        QuickSort.quickSort(arr);
        assertArrayEquals(exp, arr);
    }
}