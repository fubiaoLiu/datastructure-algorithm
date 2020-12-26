package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _943_Test {
    _943_最短超级串 obj = new _943_最短超级串();

    @Test
    public void test1() {
        String[] strings = {"alex", "loves", "leetcode"};
        assertEquals("alexlovesleetcode", obj.shortestSuperstringAnswer(strings));
//        assertEquals("alexlovesleetcode", obj.shortestSuperstring(strings));
    }

    @Test
    public void test2() {
        String[] strings = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        assertEquals("gctaagttcatgcatc", obj.shortestSuperstringAnswer(strings));
//        assertEquals("gctaagttcatgcatc", obj.shortestSuperstring(strings));
    }
}