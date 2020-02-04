package leetcode.dynamicprogramming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/4
 */
public class _53_最大连续子序和 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int max = sums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] > 0 ? sums[i - 1] + nums[i] : nums[i];
            max = Math.max(max, sums[i]);
        }
        return max;
    }

    /**
     * 分治 - 时间复杂度O(nlogn)、空间复杂度O(logn)
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray2(nums, 0, nums.length);
    }

    public int maxSubArray2(int[] nums, int begin, int end) {
        if (end - begin < 2) {
            return nums[begin];
        }
        int mid = (begin + end) >> 1;
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int i = mid + 1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax,
                Math.max(maxSubArray2(nums, begin, mid), maxSubArray2(nums, mid, end)));
    }

    /**
     * 暴力解法 - 计算每一个连续字段的和再求最大值
     * 时间复杂度O(n ^ 2)、空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
