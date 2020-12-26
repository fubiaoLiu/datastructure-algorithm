package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _977_Test {
    _977_有序数组的平方 sortedSquares = new _977_有序数组的平方();

    @Test
    public void test1() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] actualResult = sortedSquares.sortedSquares(nums);

        int[] expected = {0, 1, 9, 16, 100};
        for (int i = 0; i < nums.length; i++) {
            assertEquals(expected[i], actualResult[i]);
        }
    }
}