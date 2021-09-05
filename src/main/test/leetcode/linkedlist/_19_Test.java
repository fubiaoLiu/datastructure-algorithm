package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static utils.Assertions.assertEquals;

public class _19_Test {
    _19_删除链表的倒数第N个结点 obj = new _19_删除链表的倒数第N个结点();

    @Test
    public void test1() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        int n = 2;

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(5);

        ListNode actual = obj.removeNthFromEnd(root, n);
        assertEquals(expected,actual);
    }

    @Test
    public void test2() {
        ListNode root = new ListNode(2);

        int n = 1;

        ListNode expected = null;

        ListNode actual = obj.removeNthFromEnd(root, n);

        assertEquals(expected,actual);
    }

    @Test
    public void test3() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        int n = 1;

        ListNode expected = new ListNode(1);

        ListNode actual = obj.removeNthFromEnd(root, n);
        assertEquals(expected,actual);
    }
}
