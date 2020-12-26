package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _70_Test {
    _70_爬楼梯 obj = new _70_爬楼梯();

    @Test
    public void test1() {
        assertEquals(2, obj.climbStairs(2));
    }

    @Test
    public void test2() {
        assertEquals(3, obj.climbStairs(3));
    }
}