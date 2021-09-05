package leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _7_Test {
    _7_整数反转 obj = new _7_整数反转();

    @Test
    public void test1() {
        int x = 123;
        int expected = 321;
        int actual = obj.reverse(x);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int x = -123;
        int expected = -321;
        int actual = obj.reverse(x);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int x = 120;
        int expected = 21;
        int actual = obj.reverse(x);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int x = 0;
        int expected = 0;
        int actual = obj.reverse(x);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int x = 1534236469;
        // 1056389759
        int expected = 0;
        int actual = obj.reverse(x);
        assertEquals(expected, actual);
    }
}
