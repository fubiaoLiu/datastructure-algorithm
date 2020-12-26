package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _5_Test {
    _5_最长回文子串 longestPalindrome = new _5_最长回文子串();

    @Test
    public void test1() {
        String actual = longestPalindrome.longestPalindrome("babad");
        assertTrue("aba".equals(actual) || "bab".equals(actual));
    }

    @Test
    public void test2() {
        String actual = longestPalindrome.longestPalindrome("cbbd");
        assertEquals("bb", actual);
    }

    @Test
    public void test3() {
        String actual = longestPalindrome.longestPalindrome("a");
        assertEquals("a", actual);
    }

    @Test
    public void test4() {
        String actual = longestPalindrome.longestPalindrome("ababababababa");
        assertEquals("ababababababa", actual);
    }

    @Test
    public void test5() {
        String actual = longestPalindrome.longestPalindrome("abcda");
        assertEquals("a", actual);
    }

    @Test
    public void testPreprocess() {
        String actual = new String(longestPalindrome.preprocess("abcda".toCharArray()));
        String expected = "^#a#b#c#d#a#*";
        assertEquals(expected, actual);
    }
}