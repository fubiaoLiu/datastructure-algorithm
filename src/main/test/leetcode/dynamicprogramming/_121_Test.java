package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _121_Test {
    _121_买股票的最佳时机 obj = new _121_买股票的最佳时机();

    @Test
    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, obj.maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, obj.maxProfit(prices));
    }
}