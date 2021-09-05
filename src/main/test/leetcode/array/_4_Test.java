package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _4_Test {
    _4_寻找两个正序数组的中位数 obj = new _4_寻找两个正序数组的中位数();

    @Test
    public void test1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double expected = 2;
        double actual = obj.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double expected = 2.5;
        double actual = obj.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        double expected = 0;
        double actual = obj.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums1 = {};
        int[] nums2 = {1};
        double expected = 1;
        double actual = obj.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums1 = {2};
        int[] nums2 = {};
        double expected = 2;
        double actual = obj.findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }
}
