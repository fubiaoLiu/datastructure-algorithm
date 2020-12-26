package utils;

import leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义断言工具类
 *
 * @author Fubiao.Liu
 * @since 2020/12/22
 */
public class Assertions {
    /**
     * 断言两棵树是否相等（val相等则相等）
     */
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

    /**
     * 断言两个List是否相等，不要求顺序一致
     */
    public static void assertListEqualsDisorder(List<String> list1, List<String> list2) {
        if (list1 == null && list2 == null) {
            return;
        }
        assert list1 != null;
        assert list2 != null;
        assert list1.size() == list2.size();
        String[] array1 = new String[list1.size()];
        list1.toArray(array1);
        String[] array2 = new String[list2.size()];
        list2.toArray(array2);
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            assert array1[i].equals(array2[i]);
        }
    }
}
