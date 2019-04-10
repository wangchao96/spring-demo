package leetcode;

import java.util.*;

public class UncommonFromSentences_884 {
    /**
     * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
     * <p>
     * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
     * <p>
     * 返回所有不常用单词的列表。
     * <p>
     * 您可以按任何顺序返回列表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：A = "this apple is sweet", B = "this apple is sour"
     * 输出：["sweet","sour"]
     * 示例 2：
     * <p>
     * 输入：A = "apple apple", B = "banana"
     * 输出：["banana"]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= A.length <= 200
     * 0 <= B.length <= 200
     * A 和 B 都只包含空格和小写字母。
     */

    /**
     * 方法：计数
     * 思路和算法
     * <p>
     * 每个不常见的单词总共只出现一次。我们可以统计每个单词的出现次数，然后返回恰好出现一次的单词。
     * <p>
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(M + N)O(M+N)，其中 M, NM,N 分别是 A 和 B 的长度。
     * <p>
     * 空间复杂度：O(M + N)O(M+N)，count 所用去的空间。
     */
    class Solution {

        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> count = new HashMap<String, Integer>();
            for (String word : A.split(" ")) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            for (String word : B.split(" ")) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }


            List<String> ans = new LinkedList<>();
            for (String key : count.keySet()) {
                if (count.get(key) == 1) {
                    ans.add(key);
                }
            }
            return ans.toArray(new String[ans.size()]);
        }
    }

    public static void main(String[] args) {
        String[] strings1 = new String[10];
        for (int i = 0; i < 10; i++) {
            strings1[i] = i + "";
        }
        String[] strings2 = new String[5];
        System.arraycopy(strings1, 0, strings2, 0, 2);
        helper(strings1);
        helper(strings2);

    }

    public static void helper(String[] strings) {
        for (String str : strings
        ) {
            System.out.print(str + ",");
        }
        System.out.println("");
    }
}
