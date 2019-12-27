package linkedlist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2019/12/27
 */
public class _203_移除链表元素 {
    /**
     * 迭代
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 递归
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements2(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;
    }
}
