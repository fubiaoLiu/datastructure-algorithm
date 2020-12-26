package leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _155_Test {
    _155_最小栈 obj = new _155_最小栈();

    @Test
    public void test1() {
        obj.push(3);
        obj.push(5);
        obj.push(1);
        assertEquals(1, obj.getMin());
        assertEquals(1, obj.top());
        obj.pop();
        assertEquals(3, obj.getMin());
        obj.push(2);
        assertEquals(2, obj.getMin());
    }
}