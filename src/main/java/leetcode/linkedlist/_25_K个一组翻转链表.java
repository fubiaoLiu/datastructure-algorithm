package leetcode.linkedlist;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * Related Topics 链表
 * <p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author Fubiao.Liu
 * @since 2020/12/4 17:26
 **/
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        int i = k;
        ListNode subHead = head, subTail = head;
        while (subTail != null) {
            subTail = subTail.next;
            if (--i == 0) {
                newTail.next = reverseK(subHead, k);
                newTail = subHead;
                subHead = subTail;
                i = k;
            }
        }
        newTail.next = subHead;
        return newHead.next;
    }

    /**
     * 翻转其中k个节点
     *
     * @param head 这个k个节点中的头节点
     * @param k    k
     * @return 新的头节点
     */
    private ListNode reverseK(ListNode head, int k) {
        ListNode newHead = null;
        ListNode tmp;
        for (int i = 0; i < k; i++) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}