package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.Assertions.assertListEqualsDisorder;

public class _52_Test {
    _52_N皇后2 obj = new _52_N皇后2();

    @Test
    public void test1() {
        int n = 4;
        int expected = 2;
        int actual = obj.totalNQueens(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 1;
        int expected = 1;
        int actual = obj.totalNQueens(n);
        assertEquals(expected, actual);
    }
}