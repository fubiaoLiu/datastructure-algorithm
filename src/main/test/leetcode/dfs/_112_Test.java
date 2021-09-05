package leetcode.dfs;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Assertions.assertListEqualsDisorder;

public class _112_Test {
    _112_路径总和 obj = new _112_路径总和();

    @Test
    public void test1() {
        int sum = 22;
        TreeNode tree = getTree1();
        assertTrue(obj.hasPathSum(tree, sum));
    }

    @Test
    public void test2() {
        int sum = 1;
        TreeNode tree = getTree2();
        assertFalse(obj.hasPathSum(tree, sum));
    }

    private TreeNode getTree1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        return root;
    }

    private TreeNode getTree2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        return root;
    }
}