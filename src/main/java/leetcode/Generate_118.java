package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_118 {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     *
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> resultList;
            for (int i = 0; i < numRows; i++) {
                resultList = new ArrayList<Integer>(i + 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i){
                        resultList.add(1);
                        continue;
                    }
                    resultList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                result.add(resultList);
            }
            return result;
        }
    }
}
