package leetcode.tree;

/**
 * 自定义断言工具类
 *
 * @author Fubiao.Liu
 * @since 2020/12/22
 */
public class Assertions {
    public static void assertTreeEquals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        assert node1 != null;
        assert node2 != null;
        assert node1.val == node2.val;
        assertTreeEquals(node1.left, node2.left);
        assertTreeEquals(node1.right, node2.right);
    }
}
