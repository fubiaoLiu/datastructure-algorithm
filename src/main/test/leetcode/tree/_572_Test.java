package leetcode.tree;

import org.junit.jupiter.api.Test;

import static utils.Assertions.assertTreeEquals;
import static org.junit.jupiter.api.Assertions.*;

public class _572_Test {
    _572_另一个树的子树 obj = new _572_另一个树的子树();

    @Test
    public void testSerialization() {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);
        String expected = "#!#!1!#!#!2!4!#!#!5!3!";
        System.out.println(obj.postSerialize(tree1));
        assertEquals(expected, obj.postSerialize(tree1));
    }
    @Test
    public void testDeserialization() {
        String string = "#!#!1!#!#!2!4!#!#!5!3!";
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(4);
        expected.right = new TreeNode(5);
        expected.left.left = new TreeNode(1);
        expected.left.right = new TreeNode(2);
        assertTreeEquals(expected, obj.postDeserialize(string));
    }

    @Test
    public void test1() {
        TreeNode tree1 = new TreeNode(3);
        tree1.left = new TreeNode(4);
        tree1.right = new TreeNode(5);
        tree1.left.left = new TreeNode(1);
        tree1.left.right = new TreeNode(2);

        TreeNode tree2 = new TreeNode(4);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);

        assertTrue(obj.isSubtree(tree1, tree2));
    }
}