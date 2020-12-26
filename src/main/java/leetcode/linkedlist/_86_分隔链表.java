package leetcode.linkedlist;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * Related Topics 链表 双指针
 * <p>
 * https://leetcode-cn.com/problems/partition-list
 *
 * @author Fubiao.Liu
 * @since 2020/12/3 15:38
 **/
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) {
                lTail = lTail.next = head;
            } else {
                rTail = rTail.next = head;
            }
            head = head.next;
        }
        rTail.next = null;
        lTail.next = rHead.next;
        return lHead.next;
    }
}