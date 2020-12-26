package leetcode.characterstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _72_Test {
    _72_编辑距离 obj = new _72_编辑距离();

    @Test
    public void test1() {
        String word1 = "horse", word2 = "ros";
        assertEquals(3, obj.minDistance(word1, word2));
    }

    @Test
    public void test2() {
        String word1 = "intention", word2 = "execution";
        assertEquals(5, obj.minDistance(word1, word2));
    }
}