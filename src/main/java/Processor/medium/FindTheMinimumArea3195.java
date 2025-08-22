package src.main.java.Processor.medium;

public class FindTheMinimumArea3195 {
    class Solution {
        public int minimumArea(int[][] grid) {
            if (grid.length < 1)
                return 0;
            int m = grid.length, n = grid[0].length;
            int top = m - 1, left = n - 1, bottom = 0, right = 0;
            findFirst:
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] != 0) {
                        top = bottom = i;
                        left = right = j;
                        break findFirst;
                    }
            findLast:
            for (int i = m - 1; i >= bottom; i--)
                for (int j = n - 1; j >= 0; j--)
                    if (grid[i][j] != 0) {
                        bottom = i;
                        left = Math.min(left, j);
                        right = Math.max(right, j);
                        break findLast;
                    }
            findLeft:
            for (int j = 0; j < left; j++)
                for (int i = top; i <= bottom; i++)
                    if (grid[i][j] != 0) {
                        left = j;
                        break findLeft;
                    }
            findRight:
            for (int j = n - 1; j > right; j--)
                for (int i = top; i <= bottom; i++)
                    if (grid[i][j] != 0) {
                        right = j;
                        break findRight;
                    }
            return (bottom - top + 1) * (right - left + 1);
        }
    }
}
