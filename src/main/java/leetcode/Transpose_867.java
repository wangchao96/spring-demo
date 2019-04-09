package leetcode;

public class Transpose_867 {
    /**
     * 给定一个矩阵 A， 返回 A 的转置矩阵。
     * <p>
     * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[1,4,7],[2,5,8],[3,6,9]]
     * 示例 2：
     * <p>
     * 输入：[[1,2,3],[4,5,6]]
     * 输出：[[1,4],[2,5],[3,6]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length <= 1000
     * 1 <= A[0].length <= 1000
     */
    class Solution {
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][A.length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    res[j][i] = A[i][j];
                }
            }
            return res;
        }
    }
}
