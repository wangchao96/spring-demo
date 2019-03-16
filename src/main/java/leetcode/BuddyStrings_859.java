package leetcode;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings_859 {
    public static void main(String[] args) {
        String a = "abcd";
        System.out.println(a.substring(0, 0));
        System.out.println(a.substring(a.length()));
    }

    /**
     * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入： A = "ab", B = "ba"
     * 输出： true
     * 示例 2：
     * <p>
     * 输入： A = "ab", B = "ab"
     * 输出： false
     * 示例 3:
     * <p>
     * 输入： A = "aa", B = "aa"
     * 输出： true
     * 示例 4：
     * <p>
     * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
     * 输出： true
     * 示例 5：
     * <p>
     * 输入： A = "", B = "aa"
     * 输出： false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= A.length <= 20000
     * 0 <= B.length <= 20000
     * A 和 B 仅由小写字母构成。
     */
    class Solution {
        public boolean buddyStrings(String A, String B) {
            if (A == null || B == null) {
                return false;
            }
            if (A.length() != B.length()) {
                return false;
            }
            if (A.equals(B)) {
                Set<Character> set = new HashSet<Character>();
                for (int i = 0; i < A.length(); i++) {
                    if (set.contains(A.charAt(i))){
                        return true;
                    }
                    set.add(A.charAt(i));
                }
                return false;
            } else {
                int first = -1, second = -1;
                for (int i = 0; i < A.length(); i++) {
                    if (A.charAt(i) != B.charAt(i)) {
                        if (first == -1) {
                            first = i;
                        } else if (second == -1) {
                            second = i;
                        } else {
                            return false;
                        }
                    }
                }
                return second != -1 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first);
            }
        }
    }
}
