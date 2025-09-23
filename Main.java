package algorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random RAND = new Random(42);

    public static void main(String[] args) {
        System.out.println(" Just testing \n");

        testMergeSort();
        testQuickSort();
        testDeterministicSelect();
        testClosestPair();
    }

    private static void testMergeSort() {
        System.out.println("1. MergeSort:");
        int[] arr = {5, 2, 9, 1, 6, 3};
        System.out.println("before:" + Arrays.toString(arr));
        MergeSort.mergeSort(arr);
        System.out.println("after:" + Arrays.toString(arr));
        System.out.printf("comparisons: %d, assignments: %d\n\n",
                MergeSort.comparisons, MergeSort.assignments);
    }

    private static void testQuickSort() {
        System.out.println("2. QuickSort:");
        int[] arr = {9, 3, 7, 1, 8, 2};
        System.out.println("before:    " + Arrays.toString(arr));
        QuickSort.quickSort(arr);
        System.out.println("after: " + Arrays.toString(arr));
        System.out.printf("comparisons: %d, swaps: %d, Глубина: %d\n\n",
                QuickSort.comparisons, QuickSort.assignments , QuickSort.maxDepth);
    }

    private static void testDeterministicSelect() {
        System.out.println("3. Deterministic Select:");
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("massive: " + Arrays.toString(arr));

        for (int k = 1; k <= 3; k++) {
            int result = DeterministicSelect.select(arr.clone(), k);
            System.out.printf("%d-th smallest element: %d\n", k, result);
        }
        System.out.printf("comparisons: %d\n\n", DeterministicSelect.comparisons);
    }

    private static void testClosestPair() {
        System.out.println("4. Closest Pair:");
        ClosestPair.Point[] points = {
                new ClosestPair.Point(1, 2),
                new ClosestPair.Point(4, 6),
                new ClosestPair.Point(3, 1),
                new ClosestPair.Point(5, 4),
                new ClosestPair.Point(2, 3)
        };

        System.out.print("points: ");
        for (ClosestPair.Point p : points) {
            System.out.printf("(%d,%d) ", p.x, p.y);
        }
        System.out.println();

        double distance = ClosestPair.findClosestPair(points);
        System.out.printf("Minimum distance: %.2f\n", distance);
        System.out.printf("comparisons: %d\n\n", ClosestPair.comparisons);
    }
}