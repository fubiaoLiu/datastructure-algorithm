package leetcode.linkedlist;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * Related Topics 链表 双指针
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Fubiao.Liu
 * @since 2021/5/14 15:13
 **/
public class _19_删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }
        ListNode left = head, right = head;
        while (right.next != null) {
            right = right.next;
            n--;
            if (n < 0) {
                left = left.next;
            }
        }
        if (n <= 0) {
            left.next = left.next.next;
        }
        return n == 1 ? head.next : head;
    }
}
