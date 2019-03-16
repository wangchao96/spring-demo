package leetcode;

import java.util.LinkedList;

public class IsSameTree_100 {
    /*
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * 示例 1:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * 输出: true
     * 示例 2:
     *
     * 输入:      1          1
     *           /           \
     *          2             2
     *
     *         [1,2],     [1,null,2]
     *
     * 输出: false
     * 示例 3:
     *
     * 输入:       1         1
     *           / \       / \
     *          2   1     1   2
     *
     *         [1,2,1],   [1,1,2]
     *
     * 输出: false
     */
    class Solution1 {
        /**
         * 递归
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }
            return p.val == q.val && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }

    class Solution2 {
        /**
         * 非递归
         *
         * @param p
         * @param q
         * @return
         */
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            LinkedList<TreeNode> pStack = new LinkedList<TreeNode>();
            LinkedList<TreeNode> qStack = new LinkedList<TreeNode>();
            pStack.add(p);
            qStack.add(q);
            while (!pStack.isEmpty() && !qStack.isEmpty()) {
                p = pStack.removeLast();
                q = qStack.removeLast();
                if (p != null && q != null) {
                    if (p.val != q.val) {
                        return false;
                    }
                } else {
                    if (p != q) {
                        return false;
                    }
                }

                helper(p, pStack);

                helper(q, qStack);
            }
            return pStack.isEmpty() && qStack.isEmpty();
        }

        private void helper(TreeNode node, LinkedList<TreeNode> stack) {
            if (node == null) {
                return;
            }
            if (node.right != null) {
                stack.add(node.right);
                if (node.left != null) {
                    stack.add(node.left);
                } else {
                    stack.add(null);
                }
            } else {
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
    }
}
