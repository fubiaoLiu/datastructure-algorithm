package leetcode.linkedlist;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * Related Topics 链表
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 *
 * @author Fubiao.Liu
 * @since 2020/12/1 17:24
 **/
public class _160_相交链表 {
    /**
     * 拼接两个链表，使两个链表的最终长度一致，使两个链表可以从尾对齐进行比较，如下：
     * A: 1->2->3
     * B: 4->6->5->2
     * 遍历时如下，使两个链表可以从尾对齐进行比较：
     * A: 1->2->3 -> 4->6->5->2
     * B: 4->6->5->2 -> 1->2->3
     * <p>
     * 其他思路：反转链表，再从头开始比较，直到其中一个链表遍历结束
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode la = headA;
        ListNode lb = headB;

        while (true) {
            if (la == lb) {
                return la;
            }
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;

            // 下面这样会死循环，在两个节点的下一个节点都为空时，应该退出，表示没有相交节点
            // la = la.next == null ? headB : la.next;
            // lb = lb.next == null ? headA : lb.next;
        }
    }
}