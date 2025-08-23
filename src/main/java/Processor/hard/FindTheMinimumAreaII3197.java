package src.main.java.Processor.hard;

public class FindTheMinimumAreaII3197 {
    class Solution {
        private static final int MAX_INT = 1_000_000_000;

        public int minimumSum(int[][] grid) {
            if (grid.length < 1)
                return 0;
            int m = grid.length;
            int n = grid[0].length;
            int min = Integer.MAX_VALUE;
            //try first split vertical
            for (int row = 1; row < m; row++) {
                int noCutTop = minimumArea(grid, 0, row, 0, n);
                int cutOnTop = minimumSplit(grid, 0, row, 0, n);

                int noCutBot = minimumArea(grid, row, m, 0, n);
                int cutOnBot = minimumSplit(grid, row, m, 0, n);
                min = Math.min(min, Math.min(noCutTop + cutOnBot, cutOnTop + noCutBot));
            }

            //try first split horizontal
            for (int col = 1; col < n; col++) {
                int noCutLeft = minimumArea(grid, 0, m, 0, col);
                int cutOnLeft = minimumSplit(grid, 0, m, 0, col);

                int noCutRight = minimumArea(grid, 0, m, col, n);
                int cutOnRight = minimumSplit(grid, 0, m, col, n);
                min = Math.min(min, Math.min(noCutLeft + cutOnRight, cutOnLeft + noCutRight));
            }
            return min;
        }

        private int minimumSplit(int[][] grid, int top, int bot, int left, int right) {
            int splitH = cutByRow(grid, top, bot, left, right);
            int splitV = cutByCol(grid, top, bot, left, right);
            return Math.min(splitH, splitV);
        }

        private int cutByRow(int[][] grid, int top, int bot, int left, int right) {
            int min = Integer.MAX_VALUE;
            for (int row = top + 1; row < bot; row++) {
                int topArea = minimumArea(grid, top, row, left, right);
                int botArea = minimumArea(grid, row, bot, left, right);
                min = Math.min(topArea + botArea, min);
            }
            return min;
        }

        private int cutByCol(int[][] grid, int top, int bot, int left, int right) {
            int min = Integer.MAX_VALUE;
            for (int col = left + 1; col < right; col++) {
                int leftArea = minimumArea(grid, top, bot, left, col);
                int rightArea = minimumArea(grid, top, bot, col, right);
                min = Math.min(leftArea + rightArea, min);
            }
            return min;
        }

        private int minimumArea(int[][] grid, int x, int m, int y, int n) {
            if (m <= x || n <= y)
                return Integer.MAX_VALUE / 2;
            int top = m, left = n, bottom = x, right = y;
            top: for (int i = x; i < m; i++)
                for (int j = y; j < n; j++)
                    if (grid[i][j] != 0) {
                        top = i;
                        break top;
                    }
            bot: for (int i = m - 1; i >= bottom; i--)
                for (int j = n - 1; j >= y; j--)
                    if (grid[i][j] != 0) {
                        bottom = i;
                        break bot;
                    }
            left: for (int j = y; j < left; j++)
                for (int i = top; i <= bottom; i++)
                    if (grid[i][j] != 0) {
                        left = j;
                        break left;
                    }
            right: for (int j = n - 1; j > right; j--)
                for (int i = top; i <= bottom; i++)
                    if (grid[i][j] != 0) {
                        right = j;
                        break right;
                    }
            return (bottom - top + 1) * (right - left + 1);
        }
    }
}
