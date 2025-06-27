package Processor.hard;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxNumberPointsQueries2503 {
    private static class Pair implements Comparable<Pair> {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }

    private static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Cell other) {
            return this.val - other.val;
        }
    }

    private static class Node {
        Cell cell;
        Node next;

        public Node(Cell cell) {
            this.cell = cell;
            this.next = null;
        }
    }

    private int[] dx = new int[]{1, 0, -1, 0};
    private int[] dy = new int[]{0, 1, 0, -1};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int k = queries.length;
        int m = grid.length;
        int n = grid[0].length;
        Pair[] pair = new Pair[k];
        Pair[] result = new Pair[k];
        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            pair[i] = new Pair(queries[i], i);

        Arrays.sort(pair);

        Queue<Cell> queue = new PriorityQueue<>();


        // BFS
        boolean[][] visited = new boolean[m][n];
        for (boolean[] r : visited)
            Arrays.fill(r, false);
        int count = 0;
        visited[0][0] = true;
        queue.add(new Cell(0,0, grid[0][0]));

        for (int i = 0; i < k; i++) {
            int max = pair[i].val;
            var crr = queue.peek();
            while (!queue.isEmpty() && queue.peek().val <= max) {
                crr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int u = crr.x + dx[j];
                    int v = crr.y + dy[j];
                    if (isInside(u, v, m, n) && !visited[u][v]) {
                        Cell c = new Cell(u, v, grid[u][v]);
                        visited[u][v] = true;
                        queue.add(c);
                    }
                }
                count++;
            }
            result[i] = new Pair(pair[i].idx, count);
        }
        Arrays.sort(result);
        for (int i = 0; i < k; i++) {
            ans[i] = result[i].idx;
        }

        return ans;
    }

    private boolean isInside(int x, int y, int m, int n) {
        return (x >= 0 && x < m && y >= 0 && y < n);
    }

}
