package Processor.easy;

import java.util.*;

public class WildesArea1637 {
    class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            List<Integer> pointsOnX = new ArrayList<>();
            for(var i : points) {
                if (!pointsOnX.contains(i[0]))
                    pointsOnX.add(i[0]);
            }
            Collections.sort(pointsOnX);
            int max = 0;
            for (int i = 1; i < pointsOnX.size(); i++) {
                if ((pointsOnX.get(i) - pointsOnX.get(i-1)) > max) {
                    max = pointsOnX.get(i) - pointsOnX.get(i-1);
                }
            }

            return max;
        }
    }
}
