package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _283_Test {
    _283_移动零 obj = new _283_移动零();

    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        obj.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void test2() {
        int[] nums = {2, 1};
        int[] expected = {2, 1};
        obj.moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }
}
