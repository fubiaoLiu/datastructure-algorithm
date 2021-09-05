package leetcode.design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * <p>
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
 * 限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * <p>
 * Related Topics 设计
 * <p>
 * https://leetcode-cn.com/problems/lru-cache
 *
 * @author Fubiao.Liu
 * @since 2021/2/3 8:48
 **/
public class _146_LRU缓存机制 {
    private LinkedHashMap<Integer, Integer> map;

    /**
     * 这里借助了LinkedHashMap来实现，可以自己通过一个LinkedList来实现，将访问的元素移到队头，链表满了就删除队尾元素
     * 如果要实现进阶O(1)复杂度，则可以模拟LinkedHashMap写一个Map + LinkedList的结构实现
     */
    public _146_LRU缓存机制(int capacity) {
        map = new LinkedHashMap<Integer, Integer>(capacity, .75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                // 插入新元素之后再判断是否要删除最老的元素，所以要当 size > capacity 时才返回true
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
