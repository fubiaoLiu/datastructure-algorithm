package leetcode.linkedlist;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Related Topics 链表 双指针
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list
 *
 * @author Fubiao.Liu
 * @since 2020/12/3 16:01
 **/
public class _234_回文链表 {
    /**
     * 判断是否是回文链表
     * 先获取中间节点，将中间节点后半段进行翻转，然后比较
     *
     * @param head 链表头节点
     * @return true：是回文链表；false：不是回文链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 这个判断去掉也可以，这里如果成立可以提前结束，不用再找中心节点、翻转链表
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode middleNode = middleNode(head);
        ListNode rHead = reversal(middleNode.next);
        ListNode lHead = head;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                return false;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }

        return true;
    }

    /**
     * 判断是否是回文链表（不改变链表结构）
     * 先获取中间节点，将中间节点后半段进行翻转，然后比较，比较后再次翻转回来
     *
     * @param head 链表头节点
     * @return true：是回文链表；false：不是回文链表
     */
    public boolean isPalindromeNoChangeStructure(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 这个判断去掉也可以，这里如果成立可以提前结束，不用再找中心节点、翻转链表
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode middleNode = middleNode(head);
        ListNode rHead = reversal(middleNode.next);
        ListNode lHead = head;
        ListNode rHeadOld = rHead;
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }
        reversal(rHeadOld);
        return result;
    }

    /**
     * 获取中间节点
     *
     * @param head 头节点
     * @return 中间节点
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     *
     * @param head 头节点
     * @return 新的头节点
     */
    public ListNode reversal(ListNode head) {
        ListNode newHead = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 翻转链表
     *
     * @param head 头节点
     * @return 新的头节点
     */
    public ListNode reversalOld(ListNode head) {
        // 1 -> 2 -> 3 -> 4
        ListNode next = head.next;
        head.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = head;
            head = next;
            next = tmp;
        }
        return head;
    }
}