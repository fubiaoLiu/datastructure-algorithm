package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static utils.Assertions.assertEquals;

public class _148_Test {
    _148_排序链表 obj = new _148_排序链表();

    @Test
    public void test1() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);

        ListNode actual = obj.sortList(head);

        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode expected = new ListNode(-1);
        expected.next = new ListNode(0);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(4);
        expected.next.next.next.next = new ListNode(5);

        ListNode actual = obj.sortList(head);

        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode head = null;

        ListNode expected = null;

        ListNode actual = obj.sortList(head);

        assertEquals(expected, actual);
    }
}