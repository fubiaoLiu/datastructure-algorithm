package leetcode.dfs;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import utils.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Assertions.assertArrayAndListEquals;

public class _113_Test {
    _113_路径总和2 obj = new _113_路径总和2();

    @Test
    public void test1() {
        int sum = 22;
        TreeNode tree = getTree1();
        List<List<Integer>> actual = obj.pathSum(tree, sum);
        Integer[] expectedArray1 = {5, 4, 11, 2};
        Integer[] expectedArray2 = {5, 8, 4, 5};
        assertEquals(2, actual.size());
        assertArrayAndListEquals(expectedArray1, actual.get(0));
        assertArrayAndListEquals(expectedArray2, actual.get(1));
    }

    @Test
    public void test2() {
        int sum = 1;
        TreeNode tree = getTree2();
        List<List<Integer>> actual = obj.pathSum(tree, sum);
        assertEquals(0, actual.size());
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
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        return root;
    }

    private TreeNode getTree2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        return root;
    }
}