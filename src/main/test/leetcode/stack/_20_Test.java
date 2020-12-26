package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _20_Test {
    _20_有效的括号 obj = new _20_有效的括号();

    @Test
    public void test1() {
        String s = "()";
        assertTrue(obj.isValid(s));
    }

    @Test
    public void test2() {
        String s = "()[]{}";
        assertTrue(obj.isValid(s));
    }

    @Test
    public void test3() {
        String s = "(]";
        assertFalse(obj.isValid(s));
    }

    @Test
    public void test4() {
        String s = "([)]";
        assertFalse(obj.isValid(s));
    }

    @Test
    public void test5() {
        String s = "{[]}";
        assertTrue(obj.isValid(s));
    }
}