package leetcode;

import java.util.LinkedList;

public class IsSymmetric_101 {
    /*
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     */

    /**
     * 递归实现
     */
    class Solution1 {
        public boolean isSymmetric(TreeNode root) {
            return root == null || helper(root.left, root.right);
        }

        private boolean helper(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            return node1.val == node2.val && (helper(node1.left, node2.right) && helper(node1.right, node2.left));
        }
    }

    /**
     * 迭代实现
     */
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
            stack.add(root);
            stack.add(root);
            TreeNode node1, node2;
            while (!stack.isEmpty()) {
                node1 = stack.removeLast();
                node2 = stack.removeLast();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                stack.add(node1.left);
                stack.add(node2.right);
                stack.add(node1.right);
                stack.add(node2.left);
            }
            return true;
        }
    }
}
