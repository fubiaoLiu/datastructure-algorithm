package leetcode.linkedlist;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/27
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null);

        return slow;
    }
}
