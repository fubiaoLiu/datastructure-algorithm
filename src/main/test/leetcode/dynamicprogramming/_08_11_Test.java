package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _08_11_Test {
    _08_11_硬币 obj = new _08_11_硬币();

    @Test
    public void test1() {
        assertEquals(2, obj.waysToChange(5));
        assertEquals(2, obj.waysToChange2(5));
    }

    @Test
    public void test2() {
        assertEquals(4, obj.waysToChange(10));
        assertEquals(4, obj.waysToChange2(10));
    }

    @Test
    public void test3() {
        assertEquals(61446, obj.waysToChange(750));
        assertEquals(61446, obj.waysToChange1(750));
        assertEquals(61446, obj.waysToChange2(750));
    }

    @Test
    public void test4() {
        assertEquals(504188296, obj.waysToChange(900750));
        assertEquals(504188296, obj.waysToChange2(900750));
    }
}