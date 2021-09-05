package leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _202_Test {
    _202_快乐数 obj = new _202_快乐数();

    @Test
    public void test1() {
        int n = 19;
        assertTrue(obj.isHappy(n));
    }

    @Test
    public void test2() {
        int n = 2;
        assertFalse(obj.isHappy(n));
    }
}
