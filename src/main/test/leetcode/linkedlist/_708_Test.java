package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _708_Test {
    _708_循环有序链表的插入 obj = new _708_循环有序链表的插入();

    @Test
    public void test_12345() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        int val = 6;
        ListNode actualNode = obj.insert(node2, val);
        assertSame(node2, actualNode);
        assertEquals(node5.next.val, val);
        assertEquals(node5.next.next.val, 1);
    }

    @Test
    public void test_246810_1() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        int val = 5;
        ListNode actualNode = obj.insert(node2, val);
        assertSame(node2, actualNode);
        assertEquals(node2.next.val, val);
        assertSame(node2.next.next, node3);
    }

    @Test
    public void test_246810_2() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        int val = 11;
        ListNode actualNode = obj.insert(node3, val);
        assertSame(node3, actualNode);
        assertEquals(node5.next.val, val);
        assertSame(node5.next.next, node1);
    }

    @Test
    public void test_null() {
        int val = 5;
        ListNode actualNode = obj.insert(null, val);
        assertSame(val, actualNode.val);
        assertSame(actualNode, actualNode.next);
    }

    @Test
    public void test_2() {
        ListNode node1 = new ListNode(2);
        node1.next = node1;
        int val = 5;
        ListNode actualNode = obj.insert(node1, val);
        assertSame(node1, actualNode);
        assertEquals(actualNode.next.val, val);
        assertSame(actualNode, actualNode.next.next);
    }
}