package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class _86_Test {
    _86_分隔链表 obj = new _86_分隔链表();

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

        ListNode[] expected = {node1, node4, node6, node2, node3, node5};
        ListNode actual = obj.partition(node1, 3);

        ListNode node = actual;
        for (int i = 0; i < expected.length; i++, node = node.next) {
            assertSame(expected[i], node);
        }
    }
}