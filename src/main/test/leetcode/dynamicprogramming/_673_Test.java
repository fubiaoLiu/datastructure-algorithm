package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _673_Test {
    _673_最长递增子序列的个数 obj = new _673_最长递增子序列的个数();

    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 4, 7};
        assertEquals(2, obj.findNumberOfLIS(nums));
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals(5, obj.findNumberOfLIS(nums));
    }
}