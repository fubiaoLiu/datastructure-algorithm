package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: N叉树
 * @author: FuBiaoLiu
 * @date: 2020/1/2
 */
public class NodeUtil {
    public static Node tree0() {
        return null;
    }

    public static Node tree1() {
        return new Node(1);
    }

    public static Node tree2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        List<Node> children = new ArrayList<>();
        children.add(node2);
        node1.children = children;
        return node1;
    }

    public static Node tree3() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        List<Node> children = new ArrayList<>();
        children.add(node2);
        children.add(node3);
        node1.children = children;
        return node1;
    }

    public static Node tree4() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> children = new ArrayList<>();
        children.add(node2);
        children.add(node3);
        node1.children = children;

        children = new ArrayList<>();
        children.add(node4);
        node3.children = children;
        return node1;
    }

    /**
     * @return
     */
    public static Node tree5() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        List<Node> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        node1.children = children1;

        List<Node> children2 = new ArrayList<>();
        children2.add(node4);
        node2.children = children2;

        List<Node> children3 = new ArrayList<>();
        children3.add(node5);
        node3.children = children3;

        return node1;
    }

    /**
     * @return
     */
    public static Node tree6() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        List<Node> children1 = new ArrayList<>();
        children1.add(node2);
        children1.add(node3);
        children1.add(node4);
        node1.children = children1;


        List<Node> children2 = new ArrayList<>();
        children2.add(node5);
        children2.add(node6);
        children2.add(node7);
        node2.children = children2;
        return node1;
    }

    /**
     * @return
     */
    public static Node tree7() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        return node3;
    }

    /**
     * @return
     */
    public static Node tree8() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        return node1;
    }

    /**
     * @return
     */
    public static Node tree9() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        return node1;
    }
}
