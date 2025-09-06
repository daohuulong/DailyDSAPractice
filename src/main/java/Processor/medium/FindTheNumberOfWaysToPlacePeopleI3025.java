package src.main.java.Processor.medium;

import java.util.Arrays;

public class FindTheNumberOfWaysToPlacePeopleI3025 {
    class Solution {
        public int numberOfPairs(int[][] points) {
            Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int count = 0;
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    if (!isUpperLeft(points[i], points[j]))
                        continue;
                    if (hasInside(points, points[i], points[j]))
                        continue;
                    count++;
                }
            }
            return count;
        }

        private boolean isUpperLeft(int[] pointA, int[] pointB) {
            boolean upper = pointA[1] >= pointB[1];
            boolean left = pointA[0] <= pointB[0];
            return upper && left;
        }

        private boolean hasInside(int[][] points, int[] upperLeft, int[] bottomRight) {
            for (var p : points) {
                if (
                        (upperLeft[0] <= p[0] && p[0] <= bottomRight[0])
                                && (upperLeft[1] >= p[1] && p[1] >= bottomRight[1])
                )
                    return true;
            }
            return false;
        }
    }
}
