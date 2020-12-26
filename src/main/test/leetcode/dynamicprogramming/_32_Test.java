package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _32_Test {
    _32_最长有效括号 obj = new _32_最长有效括号();

    @Test
    public void test1() {
        String s = "(()";
        assertEquals(2, obj.longestValidParentheses(s));
    }

    @Test
    public void test2() {
        String s = ")()())";
        assertEquals(4, obj.longestValidParentheses(s));
    }

    @Test
    public void test3() {
        String s = "())";
        assertEquals(2, obj.longestValidParentheses(s));
    }

    @Test
    public void test4() {
        String s = "()(())";
        assertEquals(6, obj.longestValidParentheses(s));
    }
}