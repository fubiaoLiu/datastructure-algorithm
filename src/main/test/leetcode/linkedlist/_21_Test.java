package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class _21_Test {
    _21_合并两个有序链表 obj = new _21_合并两个有序链表();

    @Test
    public void test_135_246() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        ListNode actualNewNode = obj.mergeTwoLists(node1, node2);

        // expected : 1->2->3->4->5->6
        ListNode[] expected = {node1, node2, node3, node4, node5, node6};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }
    @Test
    public void test_123_146() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node4.next = node5;
        node5.next = node6;

        ListNode actualNewNode = obj.mergeTwoLists(node1, node4);

        // expected : 1->1->2->3->4->6
        ListNode[] expected = {node1, node4, node2, node3, node5, node6};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }
}