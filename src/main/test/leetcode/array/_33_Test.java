package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _33_Test {
    _33_搜索旋转排序数组 obj = new _33_搜索旋转排序数组();

    @Test
    public void test1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        int actual = obj.search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        int actual = obj.search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {1};
        int target = 0;
        int expected = -1;
        int actual = obj.search(nums, target);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3};
        int target = 1;
        int expected = 0;
        int actual = obj.search(nums, target);
        assertEquals(expected, actual);
    }
}
