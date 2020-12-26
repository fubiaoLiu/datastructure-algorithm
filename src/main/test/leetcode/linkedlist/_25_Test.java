package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class _25_Test {
    _25_K个一组翻转链表 obj = new _25_K个一组翻转链表();

    @Test
    public void test_12345_1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 1;
        ListNode actualNewNode = obj.reverseKGroup(node1, k);
        // expected : 1->2->3->4->5
        ListNode[] expected = {node1, node2, node3, node4, node5};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }

    @Test
    public void test_12345_2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 2;
        ListNode actualNewNode = obj.reverseKGroup(node1, k);
        // expected : 2->1->4->3->5
        ListNode[] expected = {node2, node1, node4, node3, node5};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }

    @Test
    public void test_12345_3() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 3;
        ListNode actualNewNode = obj.reverseKGroup(node1, k);
        // expected : 3->2->1->4->5
        ListNode[] expected = {node3, node2, node1, node4, node5};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }

    @Test
    public void test_1234_2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int k = 2;
        ListNode actualNewNode = obj.reverseKGroup(node1, k);
        // expected : 2->1->4->3
        ListNode[] expected = {node2, node1, node4, node3};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }

    @Test
    public void test_12_2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

        int k = 2;
        ListNode actualNewNode = obj.reverseKGroup(node1, k);
        // expected : 2->1
        ListNode[] expected = {node2, node1};
        for (int i = 0; i < expected.length; i++, actualNewNode = actualNewNode.next) {
            assertSame(expected[i], actualNewNode);
        }
    }
}