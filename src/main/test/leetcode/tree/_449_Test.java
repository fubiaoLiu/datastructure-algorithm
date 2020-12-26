package leetcode.tree;

import org.junit.jupiter.api.Test;

import static utils.Assertions.assertTreeEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _449_Test {
    _449_序列化和反序列化二叉搜索树 obj = new _449_序列化和反序列化二叉搜索树();
    _449_序列化和反序列化二叉搜索树1 obj1 = new _449_序列化和反序列化二叉搜索树1();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String expectedSerialize1 = "2,1,3";
        String expectedSerialize2 = "#,#,1,#,#,3,2,";
        testPlan1(root, expectedSerialize1);
        testPlan2(root, expectedSerialize2);
    }

    @Test
    public void test2() {
        // [1,null,2]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        String expectedSerialize1 = "1,2";
        String expectedSerialize2 = "#,#,#,2,1,";
        testPlan1(root, expectedSerialize1);
        testPlan2(root, expectedSerialize2);
    }

    @Test
    public void test3() {
        // [2,1,null]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        String expectedSerialize1 = "2,1";
        String expectedSerialize2 = "#,#,1,#,2,";
        testPlan1(root, expectedSerialize1);
        testPlan2(root, expectedSerialize2);
    }

    public void testPlan1(TreeNode root, String serialize) {
        assertEquals(serialize, obj.serialize(root));
        assertTreeEquals(root, obj.deserialize(serialize));
    }

    public void testPlan2(TreeNode root, String serialize) {
        assertEquals(serialize, obj1.serialize(root));
        assertTreeEquals(root, obj1.deserialize(serialize));
    }
}