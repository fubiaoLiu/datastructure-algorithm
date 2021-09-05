package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _11_Test {
    _11_盛最多水的容器 obj = new _11_盛最多水的容器();

    @Test
    public void test1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        int actual = obj.maxArea(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] height = {1, 1};
        int expected = 1;
        int actual = obj.maxArea(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] height = {4, 3, 2, 1, 4};
        int expected = 16;
        int actual = obj.maxArea(height);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] height = {1, 2, 1};
        int expected = 2;
        int actual = obj.maxArea(height);
        assertEquals(expected, actual);
    }
}
