package utils;

import leetcode.tree.TreeNode;

/**
 * 二叉树
 *
 * @author FuBiaoLiu
 * @since 2020/1/2
 */
public class TreeNodeUtil {
    public static TreeNode tree0() {
        return null;
    }

    public static TreeNode tree1() {
        return new TreeNode(1);
    }

    /**
     * 1
     *  \
     *   2
     */
    public static TreeNode tree2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = node2;
        return node1;
    }

    /**
     *   1
     *  / \
     * 2   3
     */
    public static TreeNode tree3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        return node1;
    }

    /**
     *   1
     *  / \
     * 2   3
     *      \
     *       4
     */
    public static TreeNode tree4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        return node1;
    }

    /**
     *   1
     *  / \
     * 2   3
     *      \
     *       4
     *        \
     *         5
     */
    public static TreeNode tree5() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.right = node5;
        return node1;
    }

    /**
     *     1
     *   /  \
     *  2    6
     *  \   / \
     *   3 5   7
     *  /
     * 4
     *
     */
    public static TreeNode tree6() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node1.right = node6;
        node6.left = node5;
        node6.right = node7;
        return node1;
    }

    /**
     *   3
     *  / \
     * 1   2
     *
     */
    public static TreeNode tree7() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;
        return node3;
    }

    /**
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     */
    public static TreeNode tree8() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        return node1;
    }

    /**
     *         1
     *       /   \
     *      2     5
     *     / \   / \
     *    3   4 6   7
     *   /           \
     *  8             9
     */
    public static TreeNode tree9() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node8;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;
        node7.right = node9;
        return node1;
    }

    /**
     *     1
     *    / \
     *   2   2
     *  / \
     * 3   3
     *
     */
    public static TreeNode tree10() {
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        node11.left = node21;
        node11.right = node22;
        node21.right = node31;
        node22.left = node32;
        return node11;
    }

    /**
     *       40
     *    /     \
     *   20     60
     *  /  \   /  \
     * 10  30 50  70
     *
     */
    public static TreeNode tree11() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node20 = new TreeNode(20);
        TreeNode node30 = new TreeNode(30);
        TreeNode node40 = new TreeNode(40);
        TreeNode node50 = new TreeNode(50);
        TreeNode node60 = new TreeNode(60);
        TreeNode node70 = new TreeNode(70);
        node40.left = node20;
        node40.right = node60;
        node20.left = node10;
        node20.right = node30;
        node60.left = node50;
        node60.right = node70;
        return node40;
    }

    /**
     *       50
     *    /     \
     *   30     70
     *  /  \   /  \
     * 20  40 60  80
     *             \
     *             90
     *
     */
    public static TreeNode tree12() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node20 = new TreeNode(20);
        TreeNode node30 = new TreeNode(30);
        TreeNode node40 = new TreeNode(40);
        TreeNode node50 = new TreeNode(50);
        TreeNode node60 = new TreeNode(60);
        TreeNode node70 = new TreeNode(70);
        TreeNode node80 = new TreeNode(80);
        TreeNode node90 = new TreeNode(90);
        node50.left = node30;
        node50.right = node70;
        node30.left = node20;
        node30.right = node40;
        node20.left = node10;
        node70.left = node60;
        node70.right = node80;
        node80.right = node90;
        return node50;
    }
}
