package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * _88_合并两个有序数组
 *
 * @author Fubiao.Liu
 * @since 2020/11/30 16:11
 **/
public class _88_Test {
    _88_合并两个有序数组 merge = new _88_合并两个有序数组();

    @Test
    public void test1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge.merge(nums1, m, nums2, n);

        int[] expectedResult = {1, 2, 2, 3, 5, 6};
        for (int i = 0; i < nums1.length; i++) {
            assertEquals(nums1[i], expectedResult[i]);
        }
    }
}