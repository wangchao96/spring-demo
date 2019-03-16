package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 前序遍历-递归
     *
     * @param node
     */
    public static void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 中序遍历-递归
     *
     * @param node
     */
    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }

    /**
     * 后序遍历-递归
     *
     * @param node
     */
    public static void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.val);
    }

    /**
     * BFS-广度优先遍历
     *
     * @param root
     * @return
     */
    public static void bfsTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return;
        queue.offer(root);
        int length;
        TreeNode node;
        while (!queue.isEmpty()) {
            length = queue.size();
            for (int i = 0; i < length; i++) {
                node = queue.poll();
                if (node != null) {
                    System.out.println(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
    }

    /**
     * DFS-深度优先遍历
     *
     * @param root
     * @return
     */
    public static void dfsTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.removeLast();
            System.out.println(temp.val);
            if (temp.right != null) {
                stack.offer(temp.right);
            }
            if (temp.left != null) {
                stack.offer(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println("BFS");
        TreeNode.bfsTraversal(root);

        System.out.println("DFS");
        TreeNode.dfsTraversal(root);
    }
}
