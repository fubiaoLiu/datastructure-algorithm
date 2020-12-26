package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _42_Test {
    _42_连续子数组的最大和 obj = new _42_连续子数组的最大和();

    @Test
    public void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, obj.maxSubArray(nums));
    }
}