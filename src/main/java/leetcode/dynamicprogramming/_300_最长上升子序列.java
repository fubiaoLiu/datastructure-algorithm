package leetcode.dynamicprogramming;

/**
 * LIS
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * <p>
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * <p>
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 * @author: FuBiaoLiu
 * @date: 2020/2/6
 */
public class _300_最长上升子序列 {
    /**
     * 二分搜索 - 空间复杂度：O(n)，时间复杂度：O(nlogn)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] heap = new int[nums.length];
        heap[0] = nums[0];
        int heapSize = 1;
        for (int num : nums) {
            // 使用二分搜索查找当前数值摆放的牌堆
            int begin = 0, end = heapSize;
            while (begin < end) {
                int mid = (end + begin) >> 1;
                if (heap[mid] >= num) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }

            heap[begin] = num;
            if (begin == heapSize) {
                heapSize++;
            }
        }
        return heapSize;
    }

    /**
     * 动态规划 - 空间复杂度：O(n)，时间复杂度：O(n ^ 2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            int last;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (last = dp[j] + 1) > dp[i]) {
                    dp[i] = last;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
