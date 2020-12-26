package leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class _138_Test {
    _138_复制带随机指针的链表 obj = new _138_复制带随机指针的链表();

    @Test
    public void test1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node[] nodes = {node1, node2, node3, node4, node5, node6};
        setRandomNode(node1, nodes);

        Node actual = obj.copyRandomList(node1);
        assertNodeList(node1, actual);
    }

    /**
     * 设置随机节点
     *
     * @param head  链表头节点
     * @param nodes 所有节点
     */
    private void setRandomNode(Node head, Node[] nodes) {
        while (head != null) {
            int randomInt = new Random().nextInt(nodes.length + (nodes.length >> 1));
            head.random = randomInt >= nodes.length ? null : nodes[randomInt];
            head = head.next;
        }
    }

    /**
     * 断言结果
     *
     * @param expected 期望的结果
     * @param actual   实际的结果
     */
    private void assertNodeList(Node expected, Node actual) {
        while (expected != null || actual != null) {
            assertNotNull(expected);
            assertNotNull(actual);
            assertEquals(expected.val, actual.val);
            if (expected.random != null) {
                assertNotNull(actual.random);
                assertEquals(expected.random.val, actual.random.val);
            } else {
                assertNull(actual.random);
            }
            expected = expected.next;
            actual = actual.next;
        }
    }
}