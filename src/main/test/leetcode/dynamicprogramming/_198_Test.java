package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _198_Test {
    _198_打家劫舍 obj = new _198_打家劫舍();

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        assertEquals(4, obj.rob(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 7, 9, 3, 1};
        assertEquals(12, obj.rob(nums));
    }
}