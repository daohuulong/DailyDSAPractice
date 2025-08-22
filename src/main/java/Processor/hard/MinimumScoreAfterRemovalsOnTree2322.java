package src.main.java.Processor.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumScoreAfterRemovalsOnTree2322 {
    int n;
    int[] val;
    List<Set<Integer>> ancestor;

    public void buildTree(int[] nums, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        n = nums.length;
        val = new int[n];
        ancestor = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            val[i] = nums[i];
            adj.add(new ArrayList<>());
            ancestor.add(new HashSet<>(n));
        }

        //build AdjList
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        dfs(0, adj, visited);
    }

    private void dfs(int u, List<List<Integer>> adj, boolean[] visited) {
        if (visited[u])
            return;
        visited[u] = true;
        for (var v : adj.get(u)) {
            if (!visited[v]) {
                ancestor.get(v).addAll(ancestor.get(u));
                ancestor.get(v).add(u);
                dfs(v, adj, visited);
                val[u] ^= val[v];
            }
        }
    }

    public int minimumScore(int[] nums, int[][] edges) {

        //chose 0 as root
        //precalcuate  XOR value for all node
        buildTree(nums, edges);
        //build AncestorList
        //isAncestor[i][j] = true mean j is ancestor of i
        // buildAncestorList();
        int res = Integer.MAX_VALUE;
        // find all triple tree that root is 0, i, j
        // calculate XOR value of root0, rootI, rootJ
        // if j is ancestor of i, value of val[j] = val[j] ^ val[i]
        for (int root1 = 1; root1 < n - 1; root1++) {
            for (int root2 = root1 + 1; root2 < n; root2++) {
                int value0 = val[0];
                int value1 = val[root1];
                int value2 = val[root2];
                if (ancestor.get(root1).contains(root2)) {
                    value0 ^= value2;
                    value2 ^= value1;
                } else if (ancestor.get(root2).contains(root1)) {
                    value0 ^= value1;
                    value1 ^= value2;
                } else {
                    value0 ^= value1;
                    value0 ^= value2;
                }
                int min = Math.min(value0, Math.min(value1, value2));
                int max = Math.max(value0, Math.max(value1, value2));
                if (res > (max - min)) {
                    res = max - min;
                }
            }
        }
        return res;
    }

}
