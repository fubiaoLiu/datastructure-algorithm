package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _151_Test {
    _151_翻转字符串里的单词 obj = new _151_翻转字符串里的单词();

    @Test
    public void test1() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        assertEquals(expected, obj.reverseWords(s));
    }

    @Test
    public void test2() {
        String s = "  hello world!  ";
        String expected = "world! hello";
        assertEquals(expected, obj.reverseWords(s));
    }

    @Test
    public void test3() {
        String s = "a good   example";
        String expected = "example good a";
        assertEquals(expected, obj.reverseWords(s));
    }

    @Test
    public void test4() {
        String s = "  Bob    Loves  Alice   ";
        String expected = "Alice Loves Bob";
        assertEquals(expected, obj.reverseWords(s));
    }

    @Test
    public void test5() {
        String s = "Alice does not even like bob";
        String expected = "bob like even not does Alice";
        assertEquals(expected, obj.reverseWords(s));
    }
}