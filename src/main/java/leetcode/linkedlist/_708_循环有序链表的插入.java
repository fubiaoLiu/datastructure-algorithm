package leetcode.linkedlist;

/**
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针，
 * <p>
 * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * <p>
 * 如果列表是空（给定的节点是null），你需要创建一个循环有序列表并返回这个点。
 * 否则，请返回原先给定的节点。
 * <p>
 * 要求：时间复杂度：O(n)、空间复杂度：O(1)
 * <p>
 * https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list
 *
 * @author Fubiao.Liu
 * @since 2020/12/4 16:41
 **/
public class _708_循环有序链表的插入 {
    public ListNode insert(ListNode entrance, int val) {
        if (entrance == null) {
            entrance = new ListNode(val);
            entrance.next = entrance;
            return entrance;
        } else if (entrance == entrance.next) {
            ListNode newNode = new ListNode(val);
            entrance.next = newNode;
            newNode.next = entrance;
            return entrance;
        }
        ListNode node = entrance;
        while (true) {
            if ((node.val <= val && node.next.val > val)
                    || (node.val > node.next.val && val > node.val)) {
                ListNode newNode = new ListNode(val);
                newNode.next = node.next;
                node.next = newNode;
                return entrance;
            }
            node = node.next;
        }
    }
}