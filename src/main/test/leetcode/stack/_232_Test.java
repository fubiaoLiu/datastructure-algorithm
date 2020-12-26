package leetcode.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _232_Test {
    _232_用栈实现队列 obj = new _232_用栈实现队列();

    @Test
    public void test1() {
        obj.push(1); // queue is: [1]
        obj.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, obj.peek()); // return 1
        assertEquals(1, obj.pop()); // return 1, queue is [2]
        assertFalse(obj.empty()); // return false
    }
}