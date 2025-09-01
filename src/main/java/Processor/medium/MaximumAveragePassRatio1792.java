package src.main.java.Processor.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio1792 {
    private static final int INCREMENT = 1;
    private static double changeVenue(int[] c) {
        double oldRatio = 1.0 * c[0] / c[1];
        double newRatio = 1.0 * (c[0] + INCREMENT) / (c[1] + INCREMENT);
        return newRatio - oldRatio;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Double.compare(changeVenue(b), changeVenue(a)));
        for (var cl : classes) {
            queue.add(new int[]{cl[0], cl[1]});
        }
        for (int i = 0; i < extraStudents; i += INCREMENT) {
            if (queue.isEmpty())
                break;
            var crr = queue.poll();
            queue.add(new int[]{crr[0] + INCREMENT, crr[1] + INCREMENT});
        }
        double res = 0.0;
        int total = 0;
        while (!queue.isEmpty()) {
            var crr = queue.poll();
            res += 1.0 * crr[0] / crr[1];
            total++;
        }
        return res / total;
    }

}
