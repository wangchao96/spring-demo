package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar_872 {
    /**
     * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * <p>
     * <p>
     * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
     * <p>
     * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * <p>
     * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 提示：
     * <p>
     * 给定的两颗树可能会有 1 到 100 个结点。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(T_1 + T_2)，其中 T_1, T_2T是给定的树的长度。
     * <p>
     * 空间复杂度：O(T_1 + T_2)，存储叶值所使用的空间。
     */
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leafs1 = new ArrayList<Integer>();
            List<Integer> leafs2 = new ArrayList<Integer>();
            helper(root1, leafs1);
            helper(root2, leafs2);
            if (leafs1.size() != leafs2.size()) {
                return false;
            }
            return leafs1.equals(leafs2);
        }

        private void helper(TreeNode root, List<Integer> leafs) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                leafs.add(root.val);
            }
            helper(root.left, leafs);
            helper(root.right, leafs);
        }
    }
}
