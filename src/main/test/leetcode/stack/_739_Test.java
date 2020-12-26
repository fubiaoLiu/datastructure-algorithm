package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _739_Test {
    _739_每日温度 obj = new _739_每日温度();

    @Test
    public void test1() {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        int[] actual = obj.dailyTemperatures(nums);
        assertArrayEquals(expected, actual);
    }
}