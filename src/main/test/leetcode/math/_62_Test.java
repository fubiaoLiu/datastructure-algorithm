package leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _62_Test {
    _62_圆圈中最后剩下的数字 obj = new _62_圆圈中最后剩下的数字();

    @Test
    public void test1() {
        int n = 5, m = 3;
        int expected = 3;
        int actual = obj.lastRemaining(n, m);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 10, m = 17;
        int expected = 2;
        int actual = obj.lastRemaining(n, m);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 8, m = 6;
        int expected = 0;
        int actual = obj.lastRemaining(n, m);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int n = 70866, m = 116922;
        int expected = 64165;
        int actual = obj.lastRemaining(n, m);
        assertEquals(expected, actual);
    }
}
