package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _3_Test {
    _3_无重复字符的最长子串 longestSubstringNoDuplication = new _3_无重复字符的最长子串();

    @Test
    public void should_return_abc_given_abcabcbb() {
        String text = "abcabcbb";
        int expectedSubstringLength = 3;
        int actualSubstringLength = longestSubstringNoDuplication.longOfLongestSubstring(text);
        assertEquals(expectedSubstringLength, actualSubstringLength);
    }

    @Test
    public void should_return_a_given_aaaaa() {
        String text = "aaaaa";
        int expectedSubstringLength = 1;
        int actualSubstringLength = longestSubstringNoDuplication.longOfLongestSubstring(text);
        assertEquals(expectedSubstringLength, actualSubstringLength);
    }

    @Test
    public void should_return_wke_given_pwwkew() {
        String text = "pwwkew";
        int expectedSubstringLength = 3;
        int actualSubstringLength = longestSubstringNoDuplication.longOfLongestSubstring(text);
        assertEquals(expectedSubstringLength, actualSubstringLength);
    }

    @Test
    public void should_return_au_given_au() {
        String text = "au";
        int expectedSubstringLength = 2;
        int actualSubstringLength = longestSubstringNoDuplication.longOfLongestSubstring(text);
        assertEquals(expectedSubstringLength, actualSubstringLength);
    }
}
