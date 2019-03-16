package leetcode;

public class LongestUnivaluePath_687 {
    /*
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
     * 这条路径可以经过也可以不经过根节点。
     *
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     *
     * 示例 1:
     *
     * 输入:
     *
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * 输出:
     *
     * 2
     * 示例 2:
     *
     * 输入:
     *
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * 输出:
     *
     * 2
     * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
     */
    class Solution {
        int max;

        public int longestUnivaluePath(TreeNode root) {
            max = 0;
            helper(root);
            return max;
        }

        private int helper(TreeNode root){
            if (root == null){
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            int l = 0, r = 0;
            if (root.left != null && root.left.val == root.val){
                l = left + 1;
            }
            if (root.right != null && root.right.val == root.val){
                r = right + 1;
            }
            max = Math.max(max, l + r);
            return Math.max(l, r);
        }
    }
}
