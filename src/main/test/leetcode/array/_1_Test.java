package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _1_Test {
    _1_两数之和 obj = new _1_两数之和();

    @Test
    public void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        int[] actual = obj.twoSum(nums, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        int[] actual = obj.twoSum(nums, target);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        int[] actual = obj.twoSum(nums, target);
        assertArrayEquals(expected, actual);
    }
}
