package leetcode;

public class FindTilt_563 {
    /*
     * 给定一个二叉树，计算整个树的坡度。
     *
     * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
     *
     * 整个树的坡度就是其所有节点的坡度之和。
     *
     * 示例:
     *
     * 输入:
     *          1
     *        /   \
     *       2     3
     * 输出: 1
     * 解释:
     * 结点的坡度 2 : 0
     * 结点的坡度 3 : 0
     * 结点的坡度 1 : |2-3| = 1
     * 树的坡度 : 0 + 0 + 1 = 1
     * 注意:
     *
     * 任何子树的结点的和不会超过32位整数的范围。
     * 坡度的值不会超过32位整数的范围。
     */

    /**
     * 方法：递归
     * 算法
     *
     * 从问题的描述中，可以清楚地了解到，我们需要在给定树的每个结点处找到其坡度，并将所有的坡度相加以获得最终结果。要找出任意结点的坡度，
     * 我们需要求出该结点的左子树上所有结点和以及其右子树上全部结点和的差值。
     *
     * 因此，为了找出解决方案，我们使用递归函数 traverse，在任何结点调用该函数，都会返回当前结点下面（包括其自身）的结点和。
     * 借助于任何结点的左右子结点的这一和值，我们可以直接获得该结点所对应的坡度。
     */
    class Solution {
        int tilt = 0;

        public int findTilt(TreeNode root) {
            helper(root);
            return tilt;
        }

        private int helper(TreeNode root){
            if (root == null) {
                return 0;
            }
            int left = helper(root.left);
            int right = helper(root.right);
            tilt += Math.abs(left - right);
            return left + right + root.val;
        }
    }
}
