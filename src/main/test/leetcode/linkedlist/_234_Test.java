package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class _234_Test {
    _234_回文链表 obj = new _234_回文链表();

    @Test
    public void testReversal() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode[] expected = {node4, node3, node2, node1};
        ListNode newHead = obj.reversal(node1);
        for (int i = 0; i < expected.length; i++, newHead = newHead.next) {
            assertEquals(expected[i], newHead);
        }
    }

    @Test
    public void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        assertFalse(obj.isPalindrome(node1));
    }

    @Test
    public void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        assertTrue(obj.isPalindrome(node1));
    }

    @Test
    public void test3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        assertTrue(obj.isPalindrome(node1));
    }

    @Test
    public void test4() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);

        assertFalse(obj.isPalindrome(node1));
    }

    @Test
    public void test5() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(1);

        assertTrue(obj.isPalindrome(node1));
    }
}