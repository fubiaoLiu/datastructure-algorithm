package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class _56_Test {
    _56_合并数组 obj = new _56_合并数组();

    @Test
    public void test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};

        int[][] actual = obj.merge(intervals);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};

        int[][] actual = obj.merge(intervals);
        assertArrayEquals(expected, actual);
    }
}
