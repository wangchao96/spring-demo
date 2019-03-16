package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom_107 {
    /*
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     */
    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Queue<TreeNode> stack = new LinkedList<TreeNode>();
            if (root != null) {
                stack.offer(root);
            }
            TreeNode node;
            LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
            List<Integer> resultList;
            while (!stack.isEmpty()) {
                int n = stack.size();
                resultList = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    node = stack.poll();
                    if (node != null){
                        resultList.add(node.val);
                        stack.offer(node.left);
                        stack.offer(node.right);
                    }
                }
                if (resultList.size() > 0) {
                    result.addFirst(resultList);
                }
            }
            return result;
        }
    }
}
