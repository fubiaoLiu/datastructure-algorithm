package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _5_Test {
    _5_最长回文子串 longestPalindrome = new _5_最长回文子串();

    @Test
    public void test() {
        assertThat(longestPalindrome.longestPalindrome("babad")).isEqualTo("aba");
        assertThat(longestPalindrome.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(longestPalindrome.longestPalindrome("a")).isEqualTo("a");
        assertThat(longestPalindrome.longestPalindrome("ababababababa")).isEqualTo("ababababababa");
        assertThat(longestPalindrome.longestPalindrome("abcda")).isEqualTo("a");
    }
}
