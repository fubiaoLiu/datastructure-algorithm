package leetcode.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Fubiao.Liu
 * @since 2020/12/9 15:39
 **/
public class _215_Test {
    _215_数组中的第K个最大元素 obj = new _215_数组中的第K个最大元素();

    @Test
    public void test1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        int actual = obj.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expected = 4;
        int actual = obj.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }
}