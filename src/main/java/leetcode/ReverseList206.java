package leetcode;

public class ReverseList206 {
    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */


    /**
     * 方式一：迭代
     * <p>
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     * <p>
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)。
     * 假设 n 是列表的长度，时间复杂度是 O(n)。
     * <p>
     * 空间复杂度：O(1)。
     */
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    /**
     * 方式二：递归
     * <p>
     * 递归版本稍微复杂一些，其关键在于反向工作。
     * 假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？
     * 假设列表为：n1 → … → nk-1 → nk → nk+1 → … → nm → Ø
     * <p>
     * 若从节点 nk+1 到 nm 已经被反转，而我们正处于 nk。
     * <p>
     * n1 → … → nk-1 → nk → nk+1 ← … ← nm
     * <p>
     * 我们希望 nk+1 的下一个节点指向 nk。
     * <p>
     * 所以，
     * <p>
     * nk.next.next = nk;
     * <p>
     * 要小心的是 n1 的下一个必须指向 Ø 。
     * 如果你忽略了这一点，你的链表中可能会产生循环。
     * 如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)。 假设 n 是列表的长度，那么时间复杂度为 O(n)。
     * <p>
     * 空间复杂度：O(n)。 由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     */
    class Solution2 {

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode res = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return res;
        }
    }
}
