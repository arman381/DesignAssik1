package algorithms;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final Random R = new Random(42);

    public static void main(String[] args) throws Exception {
        int[] demo = {5, 2, 9, 1, 6, 3};
        System.out.println("До:   " + Arrays.toString(demo));
        QuickSort.quickSort(demo);
        System.out.println("После:" + Arrays.toString(demo));
        System.out.printf("comparisons=%d, swaps=%d, maxDepth=%d%n",
                QuickSort.comparisons, QuickSort.swaps, QuickSort.maxDepth);

        int[] sizes = {1_000, 5_000, 10_000, 50_000, 100_000};
        Path csv = Path.of("qs_metrics.csv");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(csv))) {
            out.println("n,millis,comparisons,swaps,maxDepth");
            for (int n : sizes) {
                int[] a = R.ints(n, 0, n).toArray();

                long t0 = System.nanoTime();
                QuickSort.quickSort(a);
                long t1 = System.nanoTime();

                long ms = (t1 - t0) / 1_000_000;
                out.printf("%d,%d,%d,%d,%d%n",
                        n, ms, QuickSort.comparisons, QuickSort.swaps, QuickSort.maxDepth);
                System.out.printf("n=%d -> %d ms, depth=%d%n", n, ms, QuickSort.maxDepth);
            }
        }
        System.out.println("CSV записан: " + csv.toAbsolutePath());
    }
}