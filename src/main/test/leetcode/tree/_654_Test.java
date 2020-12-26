package leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

public class _654_Test {
    _654_最大二叉树 obj = new _654_最大二叉树();

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode expected = new TreeNode(6);
        expected.left = new TreeNode(3);
        expected.left.right = new TreeNode(2);
        expected.left.right.right = new TreeNode(1);
        expected.right = new TreeNode(5);
        expected.right.left = new TreeNode(0);

        TreeNode actual = obj.constructMaximumBinaryTree(nums);
        assertTreeEquals(expected, actual);
    }

    private void assertTreeEquals(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null) {
            return;
        }
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.val, actual.val);

        assertTreeEquals(expected.left, actual.left);
        assertTreeEquals(expected.right, actual.right);
    }

    @Test
    public void testFindParentIndexes() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        int[] actual = obj.parentIndexes(nums);
        int[] expected = {3, 0, 1, -1, 5, 3};
        printArray(actual);
        assertArrayEquals(expected, actual);
    }

    private static void printArray(int[] array) {
        if (array == null) {
            System.out.println("null");
            return;
        }
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int b : array) {
            sj.add(String.valueOf(b));
        }
        System.out.println(sj.toString());
    }
}