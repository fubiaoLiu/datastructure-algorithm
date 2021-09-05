package utils;

import leetcode.linkedlist.ListNode;
import leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 自定义断言工具类
 *
 * @author Fubiao.Liu
 * @since 2020/12/22
 */
public class Assertions<T> {
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
     * 断言两个List是否相等
     */
    public static <T> void assertListEquals(List<T> expected, List<T> actual) {
        if (expected == null && actual == null) {
            return;
        }
        assert expected != null;
        assert actual != null;
        assert expected.size() == actual.size();
        for (int i = 0; i < expected.size(); i++) {
            assert expected.get(i).equals(actual.get(i));
        }
    }

    /**
     * 断言两个List是否相等，不要求顺序一致
     */
    public static <T> void assertListEqualsDisorder(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) {
            return;
        }
        assert list1 != null;
        assert list2 != null;
        assert list1.size() == list2.size();
        T[] array1 = (T[]) new Objects[list1.size()];
        list1.toArray(array1);
        T[] array2 = (T[]) new Objects[list2.size()];
        list2.toArray(array2);
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            assert array1[i].equals(array2[i]);
        }
    }

    /**
     * 断言数组和集合中的元素相同
     */
    public static <T> void assertArrayAndListEquals(T[] array, List<T> list) {
        if (array == null && list == null) {
            return;
        }
        assert array != null;
        assert list != null;
        assert array.length == list.size();
        for (int i = 0; i < array.length; i++) {
            assert array[i].equals(list.get(i));
        }
    }

    /**
     * 断言两个链表是否相同
     */
    public static void assertEquals(ListNode expected, ListNode actual) {
        ListNode expectedNode = expected;
        ListNode actualNode = actual;
        while (expectedNode != null && actualNode != null){
            assert expectedNode.getVal() == actualNode.getVal();
            expectedNode = expectedNode.getNext();
            actualNode = actualNode.getNext();
        }
        assert expectedNode == null;
        assert actualNode == null;
    }
}
