package linkedlist;

/**
 * 反转一个单链表。
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/27
 */
public class _206_反转链表 {
    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
