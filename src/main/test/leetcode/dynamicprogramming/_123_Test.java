package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _123_Test {
    _123_买卖股票的最佳时机3 obj = new _123_买卖股票的最佳时机3();

    @Test
    public void test1() {
        int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};
        assertEquals(6, obj.maxProfit(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4, 5};
        assertEquals(4, obj.maxProfit(nums));
    }

    @Test
    public void test3() {
        int[] nums = {7, 6, 4, 3, 1};
        assertEquals(0, obj.maxProfit(nums));
    }

    @Test
    public void test4() {
        int[] nums = {2, 1, 2, 0, 1};
        assertEquals(2, obj.maxProfit(nums));
    }

    @Test
    public void test5() {
        int[] nums = {6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5};
        assertEquals(7, obj.maxProfit(nums));
    }
}