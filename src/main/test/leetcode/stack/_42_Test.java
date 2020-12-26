package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _42_Test {
    _42_接雨水 obj = new _42_接雨水();

    @Test
    public void test1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int actual = obj.trap(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        int expected = 9;
        int actual = obj.trap(height);
        assertEquals(expected, actual);
    }
}