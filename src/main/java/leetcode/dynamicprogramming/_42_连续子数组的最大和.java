package leetcode.dynamicprogramming;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * <p>
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * Related Topics 分治算法 动态规划
 * <p>
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 * @author Fubiao.Liu
 * @since 2020/12/16 13:22
 **/
public class _42_连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int maxSum = sums[0];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] > 0 ? sums[i - 1] + nums[i] : nums[i];
            maxSum = Math.max(maxSum, sums[i]);
        }
        return maxSum;
    }
}