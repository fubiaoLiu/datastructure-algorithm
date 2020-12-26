package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _213_Test {
    _213_打家劫舍2 obj = new _213_打家劫舍2();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, obj.rob(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 3, 2};
        assertEquals(3, obj.rob(nums));
    }

    @Test
    public void test3() {
        int[] nums = {0};
        assertEquals(0, obj.rob(nums));
    }
}