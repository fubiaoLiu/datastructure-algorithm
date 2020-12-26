package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class _23_Test {
    _23_合并K个升序链表 obj = new _23_合并K个升序链表();

    @Test
    public void test_135_246_78() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        node7.next = node8;

        ListNode[] lists = {node1, node2, node7};
        ListNode actualNewNode = obj.mergeKLists(lists);

        // expected : 1->2->3->4->5->6->7->8
        ListNode[] expected = {node1, node2, node3, node4, node5, node6, node7, node8};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }

    @Test
    public void test_135_246_15() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(5);
        node1.next = node3;
        node3.next = node5;

        node2.next = node4;
        node4.next = node6;

        node7.next = node8;

        ListNode[] lists = {node1, node2, node7};
        ListNode actualNewNode = obj.mergeKLists(lists);

        // expected : 1->1->2->3->4->5->5->6
        ListNode[] expected = {node1, node7, node2, node3, node4, node5, node8, node6};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }
}