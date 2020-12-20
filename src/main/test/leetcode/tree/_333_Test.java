package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _333_Test {
    _333_最大BST子树 obj = new _333_最大BST子树();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertEquals(3, obj.largestBSTSubtree(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(14);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(16);
        root.left.right.left = new TreeNode(11);
        root.left.right.left.left = new TreeNode(8);
        root.left.right.left.right = new TreeNode(13);
        root.left.right.right = new TreeNode(25);
        root.left.right.right.left = new TreeNode(22);
        root.left.right.right.right = new TreeNode(29);

        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        assertEquals(7, obj.largestBSTSubtree(root));
    }
}
