package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _188_Test {
    _188_买卖股票的最佳时机4 obj = new _188_买卖股票的最佳时机4();

    @Test
    public void test1() {
        int k = 2;
        int[] nums = {2, 4, 1};
        assertEquals(2, obj.maxProfit(k, nums));
    }

    @Test
    public void test2() {
        int k = 2;
        int[] nums = {3, 2, 6, 5, 0, 3};
        assertEquals(7, obj.maxProfit(k, nums));
    }

    @Test
    public void test3() {
        int k = 2;
        int[] nums = {3, 2, 6, 5, 7, 3};
        assertEquals(6, obj.maxProfit(k, nums));
    }
}