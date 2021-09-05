package leetcode.dfs;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _124_Test {
    _124_二叉树中的最大路径和 obj = new _124_二叉树中的最大路径和();

    @Test
    public void test1() {
        TreeNode tree = getTree1();
        int expected = 6;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        TreeNode tree = getTree2();
        int expected = 42;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        TreeNode tree = new TreeNode(-3);
        int expected = -3;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(-1);
        int expected = 2;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        TreeNode tree = getTree5();
        int expected = 48;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        TreeNode tree = getTree6();
        int expected = 9;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        TreeNode tree = getTree7();
        int expected = 3;
        int actual = obj.maxPathSum(tree);
        assertEquals(expected, actual);
    }

    private TreeNode getTree1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        return root;
    }

    private TreeNode getTree2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    private TreeNode getTree5() {
        // [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        return root;
    }

    private TreeNode getTree6() {
        // [9,-3,0,3,null,null,null,null,-8]
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-8);

        root.right = new TreeNode(0);

        return root;
    }

    private TreeNode getTree7() {
        // [1,null,-7,-9,-8,null,null,3,null,null,-2]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(-7);
        root.right.left = new TreeNode(-9);
        root.right.right = new TreeNode(-8);
        root.right.right.left = new TreeNode(3);
        root.right.right.left.right = new TreeNode(-2);

        return root;
    }
}