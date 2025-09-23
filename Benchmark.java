package algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Benchmark {
    private static final Random RAND = new Random(123);

    public static void main(String[] args) throws Exception {
        runAll("metrics.csv");
        System.out.println("Метрики сохранены в metrics.csv");
    }

    public static void runAll(String csvPath) throws IOException {
        try (FileWriter fw = new FileWriter(csvPath)) {
            fw.write("algo,n,time_ms,comparisons,assignments,maxDepth\n");
            int[] ns = new int[]{1000, 2000, 5000, 10000, 20000};

            for (int n : ns) {
                int[] base = randomArray(n);


                int[] a = base.clone();
                long t0 = System.nanoTime();
                MergeSort.mergeSort(a);
                long t1 = System.nanoTime();
                fw.write(String.format("MergeSort,%d,%.3f,%d,%d,%d\n",
                        n, (t1 - t0) / 1e6, MergeSort.comparisons, MergeSort.assignments, 0));


                a = base.clone();
                t0 = System.nanoTime();
                QuickSort.quickSort(a);
                t1 = System.nanoTime();
                fw.write(String.format("QuickSort,%d,%.3f,%d,%d,%d\n",
                        n, (t1 - t0) / 1e6, QuickSort.comparisons, QuickSort.assignments, QuickSort.maxDepth));


                a = base.clone();
                int k = n / 2;
                t0 = System.nanoTime();
                DeterministicSelect.select(a, k);
                t1 = System.nanoTime();
                fw.write(String.format("SelectMoM5,%d,%.3f,%d,%d,%d\n",
                        n, (t1 - t0) / 1e6, DeterministicSelect.comparisons, 0, 0));
            }
        }
    }

    private static int[] randomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = RAND.nextInt();
        return a;
    }
}