package leetcode.linkedlist;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * Related Topics 排序 链表
 * <p>
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author Fubiao.Liu
 * @since 2021/5/17 16:48
 **/
public class _148_排序链表 {
    /**
     * 题解：自底向上归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    /**
     * 超时了
     * 时间复杂度O(n ^ 2)
     */
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode pre = head;
        ListNode node = head.next;
        int count = 1;
        while (node != null) {
            if (pre.val > node.val) {
                int tmp = pre.val;
                pre.val = node.val;
                node.val = tmp;
            }
            pre = node;
            node = node.next;
            count++;
        }

        while (count > 0) {
            pre = head;
            node = head.next;
            int i = count;
            while (i > 1) {
                if (pre.val > node.val) {
                    int tmp = pre.val;
                    pre.val = node.val;
                    node.val = tmp;
                }
                pre = node;
                node = node.next;
                i--;
            }
            count--;
        }

        return dummyHead.next;
    }
}
