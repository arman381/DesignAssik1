package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    public static long comparisons = 0;

    public static double findClosestPair(Point[] points) {
        comparisons = 0;
        if (points == null || points.length < 2) {
            return Double.POSITIVE_INFINITY;
        }

        Point[] pointsX = points.clone();
        Arrays.sort(pointsX, Comparator.comparingInt(p -> p.x));

        Point[] pointsY = points.clone();
        Arrays.sort(pointsY, Comparator.comparingInt(p -> p.y));

        return closestPair(pointsX, pointsY, 0, points.length - 1);
    }

    private static double closestPair(Point[] pointsX, Point[] pointsY, int left, int right) {
        if (right - left <= 3) {
            return bruteForce(pointsX, left, right);
        }

        int mid = left + (right - left) / 2;
        Point midPoint = pointsX[mid];

        Point[] leftY = new Point[mid - left + 1];
        Point[] rightY = new Point[right - mid];
        int leftIdx = 0, rightIdx = 0;

        for (Point point : pointsY) {
            comparisons++;
            if (point.x <= midPoint.x && leftIdx < leftY.length) {
                leftY[leftIdx++] = point;
            } else if (rightIdx < rightY.length) {
                rightY[rightIdx++] = point;
            }
        }

        double dLeft = closestPair(pointsX, leftY, left, mid);
        double dRight = closestPair(pointsX, rightY, mid + 1, right);
        double d = Math.min(dLeft, dRight);

        Point[] strip = new Point[right - left + 1];
        int stripSize = 0;
        for (Point point : pointsY) {
            comparisons++;
            if (Math.abs(point.x - midPoint.x) < d) {
                strip[stripSize++] = point;
            }
        }

        return Math.min(d, stripClosest(strip, stripSize, d));
    }

    private static double bruteForce(Point[] points, int left, int right) {
        double minDist = Double.POSITIVE_INFINITY;
        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                double dist = distance(points[i], points[j]);
                comparisons++;
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    private static double stripClosest(Point[] strip, int size, double d) {
        double minDist = d;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < minDist; j++) {
                double dist = distance(strip[i], strip[j]);
                comparisons++;
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }
        return minDist;
    }

    private static double distance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}