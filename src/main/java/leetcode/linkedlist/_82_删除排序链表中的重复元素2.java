package leetcode.linkedlist;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * Related Topics 链表
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>
 *
 * @author FuBiaoLiu
 * @since 2020/1/14
 */
public class _82_删除排序链表中的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode virtual = null;
        ListNode slow = head;
        ListNode fast = head.next;
        do {
            if (slow.val != fast.val) {
                if (slow.next == fast) {
                    virtual = slow;
                } else if (virtual == null) {
                    head = fast;
                } else {
                    virtual.next = fast;
                }
                slow = fast;
            } else if (fast.next == null) {
                if (virtual == null) {
                    head = null;
                } else {
                    virtual.next = null;
                }
            }
        } while ((fast = fast.next) != null);
        return head;
    }
}
