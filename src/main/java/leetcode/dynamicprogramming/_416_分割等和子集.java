package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * @author Fubiao.Liu
 * @since 2021/6/7 16:24
 **/
public class _416_分割等和子集 {
    /**
     * 动态规划 - 二维数组
     * 1、先计算平均值
     * 2、转换为背包问题
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return (total & 1) == 0 && dp(nums, total >> 1);
    }

    /**
     * 动态规划 - 二维数组 - 优化（二维数组大小为2）
     * 背包问题
     */
    public boolean dp(int[] nums, int target) {
        boolean[][] dp = new boolean[2][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int remain = j - nums[i - 1];
                if (dp[(i - 1) & 1][j] || remain == 0 || (remain > 0 && dp[(i - 1) & 1][remain])) {
                    dp[i & 1][j] = true;
                }
            }
            if (dp[i & 1][target]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 动态规划 - 二维数组
     * 背包问题
     */
    public boolean dp1(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int remain = j - nums[i - 1];
                if (dp[i - 1][j] || remain == 0 || (remain > 0 && dp[i - 1][remain])) {
                    dp[i][j] = true;
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 题解
     */
    public boolean canPartition1(int[] nums) {
        int sum1 = 0, sum2 = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum1 < sum2) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        if (sum1 == sum2) return true;
        if ((sum1 + sum2) % 2 == 1) return false;
        sum1 = (sum1 + sum2) / 2;
        sum2 = sum1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum1 < nums[i]) {
                sum2 -= nums[i];
            } else {
                sum1 -= nums[i];
            }
        }
        return sum1 == sum2;
    }
}
