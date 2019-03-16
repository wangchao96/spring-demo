package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;

public class MaxDepth_104 {
    /*
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */

    /**
     * 递归实现
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int leftLength = maxDepth(root.left);
                int rightLength = maxDepth(root.right);
                return Math.max(leftLength, rightLength) + 1;
            }
        }
    }

    /**
     * 迭代实现
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<Pair<TreeNode, Integer>>();
            if (root != null) {
                stack.add(new Pair<TreeNode, Integer>(root, 1));
            }
            int maxDepth = 0;
            while (!stack.isEmpty()) {
                Pair<TreeNode, Integer> pair = stack.removeLast();
                TreeNode node = pair.getKey();
                if (node != null) {
                    int currentDepth = pair.getValue();
                    maxDepth = Math.max(maxDepth, currentDepth);
                    stack.add(new Pair<TreeNode, Integer>(node.left, currentDepth + 1));
                    stack.add(new Pair<TreeNode, Integer>(node.right, currentDepth + 1));
                }
            }
            return maxDepth;
        }
    }
}
