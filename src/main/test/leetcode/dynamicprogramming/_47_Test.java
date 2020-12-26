package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _47_Test {
    _47_礼物的最大价值 obj = new _47_礼物的最大价值();

    @Test
    public void test1() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        assertEquals(12, obj.maxValue(grid));
    }
}