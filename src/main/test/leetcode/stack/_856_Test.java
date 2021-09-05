package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _856_Test {
    _856_括号的分数 obj = new _856_括号的分数();

    @Test
    public void test1() {
        String s = "(()(()))";

        int expected = 6;
        int actual = obj.scoreOfParentheses1(s);
        assertEquals(expected, actual);
    }
}