package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _516_Test {
    _516_最长回文子序列 obj = new _516_最长回文子序列();

    @Test
    public void test1() {
        String s = "bbbab";
        assertEquals(4, obj.longestPalindromeSubseq(s));
    }

    @Test
    public void test2() {
        String s = "cbbd";
        assertEquals(2, obj.longestPalindromeSubseq(s));
    }

    @Test
    public void test3() {
        String s = "a";
        assertEquals(1, obj.longestPalindromeSubseq(s));
    }

    @Test
    public void test4() {
        String s = "aa";
        assertEquals(2, obj.longestPalindromeSubseq(s));
    }

    @Test
    public void test5() {
        String s = "aaa";
        assertEquals(3, obj.longestPalindromeSubseq(s));
    }
}