package Processor.medium;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor1123 {
    
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        TreeNode res = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int deph = 0;
        int maxDeph = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            deph++;
            for (int i = 0; i < size; i++) {
                var crr = queue.poll();
                if (crr.left == null && crr.right == null) {
                    continue;
                }
                if (crr.left != null) {
                    queue.add(crr.left);
                }
                if (crr.right != null) {
                    queue.add(crr.right);
                }
                if (deph > maxDeph) {
                    maxDeph = deph;
                    res = crr;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
