package leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _98_Test {
    _98_验证二叉搜索树 obj = new _98_验证二叉搜索树();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        assertTrue(obj.isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        assertFalse(obj.isValidBST(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        assertFalse(obj.isValidBST(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(-2147483648);
        assertTrue(obj.isValidBST(root));
    }
}
