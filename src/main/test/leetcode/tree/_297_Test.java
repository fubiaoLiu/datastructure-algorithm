package leetcode.tree;

import org.junit.jupiter.api.Test;
import utils.TreeNodeUtil;

import static utils.Assertions.assertTreeEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _297_Test {
    _297_二叉树的序列化与反序列化 obj = new _297_二叉树的序列化与反序列化();

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.tree8();
        String expected = "1,2,3,Null,Null,4,Null,Null,5,Null,6,Null,Null,";
        String actual = obj.serialize(tree);
        assertEquals(expected, actual);

        TreeNode actualTree = obj.deserialize(actual);
        assertTreeEquals(tree, actualTree);
    }
}
