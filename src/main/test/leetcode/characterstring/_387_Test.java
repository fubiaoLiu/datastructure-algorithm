package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _387_Test {
    _387_字符串中的第一个唯一字符 obj = new _387_字符串中的第一个唯一字符();

    @Test
    public void test1() {
        String s = "leetcode";
        int expected = 0;
        assertEquals(expected, obj.firstUniqChar(s));
    }

    @Test
    public void test2() {
        String s = "loveleetcode";
        int expected = 2;
        assertEquals(expected, obj.firstUniqChar(s));
    }
}
