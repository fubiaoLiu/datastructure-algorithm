package leetcode.linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * Related Topics 链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists
 *
 * @author Fubiao.Liu
 * @since 2020/12/5 16:01
 **/
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (true) {
            if (l1 == null) {
                newTail.next = l2;
                break;
            }
            if (l2 == null) {
                newTail.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                newTail = newTail.next = l1;
                l1 = l1.next;
            } else {
                newTail = newTail.next = l2;
                l2 = l2.next;
            }
        }
        return newHead.next;
    }
}