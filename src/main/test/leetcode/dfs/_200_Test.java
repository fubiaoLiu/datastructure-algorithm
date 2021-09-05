package leetcode.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _200_Test {
    _200_岛屿数量 obj = new _200_岛屿数量();

    @Test
    public void test1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        int actual = obj.numIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        int actual = obj.numIslands(grid);
        assertEquals(expected, actual);
    }
}