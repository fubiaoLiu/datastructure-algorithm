package leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _149_Test {
    _149_直线上最多的点数 obj = new _149_直线上最多的点数();

    @Test
    public void test1() {
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int expected = 3;
        int actual = obj.maxPoints(points);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int expected = 4;
        int actual = obj.maxPoints(points);
        assertEquals(expected, actual);
    }
}
