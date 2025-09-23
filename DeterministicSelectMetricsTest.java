package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeterministicSelectMetricsTest {

    @Test
    void testDeterministicSelectCorrectness() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int k = 3;
        int result = DeterministicSelect.select(arr, k);
        assertEquals(7, result, "The selected element is not correct!");
    }

    @Test
    void testDeterministicSelectMetrics() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int k = 3;
        DeterministicSelect.select(arr, k);


        assertTrue(DeterministicSelect.comparisons > 0, "Comparisons should be greater than 0");
    }
}