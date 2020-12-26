package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1048_Test {
    _1048_最长字符串链 obj = new _1048_最长字符串链();

    @Test
    public void test1() {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        assertEquals(4, obj.longestStrChainDp1(words));
        assertEquals(4, obj.longestStrChainDp2(words));
        assertEquals(4, obj.longestStrChainDFS(words));
        assertEquals(4, obj.longestStrChain(words));
    }

    @Test
    public void test2() {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        assertEquals(5, obj.longestStrChainDp1(words));
        assertEquals(5, obj.longestStrChainDp2(words));
        assertEquals(5, obj.longestStrChainDFS(words));
        assertEquals(5, obj.longestStrChain(words));
    }
}