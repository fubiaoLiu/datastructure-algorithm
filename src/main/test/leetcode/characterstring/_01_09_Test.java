package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _01_09_Test {
    _01_09_字符串轮转 obj = new _01_09_字符串轮转();

    @Test
    public void test1() {
        String s1 = "waterbottle", s2 = "erbottlewat";
        assertTrue(obj.isFlipedString(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "aa", s2 = "aba";
        assertFalse(obj.isFlipedString(s1, s2));
    }
}