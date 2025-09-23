package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClosestPairMetricsTest {

    @Test
    void testClosestPairCorrectness() {
        ClosestPair.Point[] points = {new ClosestPair.Point(0, 0), new ClosestPair.Point(1, 1), new ClosestPair.Point(2, 2), new ClosestPair.Point(3, 3)};
        double result = ClosestPair.findClosestPair(points);
        assertEquals(1.414, result, 0.001, "The closest pair distance is incorrect!");
    }

    @Test
    void testClosestPairMetrics() {
        ClosestPair.Point[] points = {new ClosestPair.Point(0, 0), new ClosestPair.Point(1, 1), new ClosestPair.Point(2, 2), new ClosestPair.Point(3, 3)};
        ClosestPair.findClosestPair(points);

        assertTrue(ClosestPair.comparisons > 0, "Comparisons should be greater than 0");

        assertEquals(ClosestPair.comparisons, 6, "Expected number of comparisons");
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}