package leetcode.dynamicprogramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
 * 房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/house-robber-ii
 *
 * @author Fubiao.Liu
 * @since 2020/12/16 16:24
 **/
public class _213_打家劫舍2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }

        // dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + nums[i]
        int[] dp1 = new int[nums.length];
        // dp2[i] = Math.max(dp2[i + 2], dp2[i + 3]) + nums[i]
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        dp1[2] = Math.max(dp1[1], nums[0] + nums[2]);
        dp2[nums.length - 1] = nums[nums.length - 1];
        dp2[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        dp2[nums.length - 3] = Math.max(dp2[nums.length - 2], nums[nums.length - 1] + nums[nums.length - 3]);
        int max = Math.max(dp1[2], dp2[nums.length - 3]);
        for (int i = 3; i < dp1.length - 1; i++) {
            int j = dp1.length - 1 - i;
            dp1[i] = Math.max(dp1[i - 2], dp1[i - 3]) + nums[i];
            dp2[j] = Math.max(dp2[j + 2], dp2[j + 3]) + nums[j];
            max = Math.max(Math.max(dp1[i], dp2[j]), max);
        }
        return max;
    }
}