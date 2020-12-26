package leetcode.linkedlist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * Related Topics 链表
 * <p>
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2019/12/27
 */
public class _203_移除链表元素 {
    /**
     * 迭代
     *
     * @param head 链表头节点
     * @param val  指定值
     * @return 新的链表头节点
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
     * @param head 链表头节点
     * @param val  指定值
     * @return 新的链表头节点
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

    /**
     * 虚拟头节点
     *
     * @param head 链表头节点
     * @param val  指定值
     * @return 新的链表头节点
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (head != null) {
            if (head.val != val) {
                newTail = newTail.next = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;
    }
}