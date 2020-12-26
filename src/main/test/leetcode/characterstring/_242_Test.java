package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _242_Test {
    _242_有效的字母异位词 obj = new _242_有效的字母异位词();

    @Test
    public void test1() {
        String s = "anagram";
        String t = "nagaram";
        assertTrue(obj.isAnagram(s, t));
    }

    @Test
    public void test2() {
        String s = "rat";
        String t = "car";
        assertFalse(obj.isAnagram(s, t));
    }
}