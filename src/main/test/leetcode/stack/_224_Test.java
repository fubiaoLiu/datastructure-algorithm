package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _224_Test {
    _224_基本计算器 obj = new _224_基本计算器();

    @Test
    public void test1() {
        String s = "1 + 1";
        int expected = 2;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = " 2-1 + 2 ";
        int expected = 3;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int expected = 23;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String s = "2147483647";
        int expected = 2147483647;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String s = "21 + 8 ";
        int expected = 29;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String s = " (21 - (18 - 1)) + 2 ";
        int expected = 6;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String s = "1-11";
        int expected = -10;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }
}