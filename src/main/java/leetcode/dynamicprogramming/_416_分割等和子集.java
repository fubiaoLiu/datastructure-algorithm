package leetcode.dynamicprogramming;

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
 * @since 2021/5/18
 */
public class _416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return (total & 1) == 0 && dp(nums, total >> 1);
        // return (total & 1) == 0 && recursion(nums, 0, total >> 1);
    }

    /**
     * 递归
     * 包含很多重复计算，所以使用动态规划来优化
     */
    private boolean recursion(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length - 1) {
            return target == nums[index];
        }
        return recursion(nums, index + 1, target) | recursion(nums, index + 1, target - nums[index]);
    }

    /**
     * 动态规划：一维数组
     * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] || nums[i] == j
     * -    0 1 2 3 4 5 6 7 8 9 10 11
     * 0    0 0 0 0 0 0 0 0 0 0 0  0
     * 1    0 1 0 0 0 0 0 0 0 0 0  0
     * 5    0 1 0 0 0 1 1 0 0 0 0  0
     * 5
     * 11
     */
    private boolean dp(int[] nums, int target) {
        return false;
    }

    /**
     * 动态规划：二维数组
     * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] || nums[i] == j
     * -    0 1 2 3 4 5 6 7 8 9 10 11
     * 0    0 0 0 0 0 0 0 0 0 0 0  0
     * 1    0 1 0 0 0 0 0 0 0 0 0  0
     * 5    0 1 0 0 0 1 1 0 0 0 0  0
     * 11   0 1 0 0 0 1 1 0 0 0 0  1
     * 5
     */
    private boolean dp2(int[] nums, int target) {
        boolean[][] dp = new boolean[2][target + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i & 1][j] = dp[(i - 1) & 1][j] || (j >= nums[i - 1] && dp[(i - 1) & 1][j - nums[i - 1]]) || nums[i - 1] == j;
            }
        }
        return dp[nums.length & 1][target];
    }

    /**
     * 动态规划：多维数组
     * dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]] || nums[i] == j
     * -    0 1 2 3 4 5 6 7 8 9 10 11
     * 0    0 0 0 0 0 0 0 0 0 0 0  0
     * 1    0 1 0 0 0 0 0 0 0 0 0  0
     * 5    0 1 0 0 0 1 1 0 0 0 0  0
     * 11   0 1 0 0 0 1 1 0 0 0 0  1
     * 5
     */
    private boolean dp1(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] || (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]]) || nums[i - 1] == j;
            }
        }
        return dp[nums.length][target];
    }
}
