package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _227_Test {
    _227_基本计算器Ⅱ obj = new _227_基本计算器Ⅱ();

    @Test
    public void test1() {
        String s = "3+2*2";
        int expected = 7;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = " 3/2 ";
        int expected = 1;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = " 3+5 / 2 ";
        int expected = 5;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String s = "0";
        int expected = 0;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String s = "0-2147483647";
        int expected = -2147483647;
        int actual = obj.calculate(s);
        assertEquals(expected, actual);
    }
}