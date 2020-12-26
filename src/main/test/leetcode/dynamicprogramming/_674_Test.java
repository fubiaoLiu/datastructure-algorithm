package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _674_Test {
    _674_最长连续递增序列 obj = new _674_最长连续递增序列();

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 4, 7};
        assertEquals(3, obj.findLengthOfLCIS(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(1, obj.findLengthOfLCIS(nums));
    }
}