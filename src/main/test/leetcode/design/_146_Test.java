package leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _146_Test {
    @Test
    public void test1() {
        _146_LRU缓存机制 lRUCache = new _146_LRU缓存机制(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        assertEquals(1, lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        assertEquals(-1, lRUCache.get(1));    // 返回 -1 (未找到)
        assertEquals(3, lRUCache.get(3));    // 返回 3
        assertEquals(4, lRUCache.get(4));    // 返回 4
    }
}