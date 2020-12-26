package leetcode.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Fubiao.Liu
 * @since 2020/12/9 15:39
 **/
public class _239_Test {
    _239_滑动窗口最大值 obj = new _239_滑动窗口最大值();

    @Test
    public void test1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        int[] actual = obj.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {7, 2, 4};
        int k = 2;
        int[] expected = {7, 4};
        int[] actual = obj.maxSlidingWindow(nums, k);
        assertArrayEquals(expected, actual);
    }
}