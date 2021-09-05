package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _416_Test {
    _416_分割等和子集 obj = new _416_分割等和子集();

    @Test
    public void test1() {
        int[] nums = {1, 5, 11, 5};
        assertTrue(obj.canPartition(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 5};
        assertFalse(obj.canPartition(nums));
    }
}