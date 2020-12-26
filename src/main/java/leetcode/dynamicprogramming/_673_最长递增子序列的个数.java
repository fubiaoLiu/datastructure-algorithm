package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * <p>
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * <p>
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 *
 * @author Fubiao.Liu
 * @since 2020/12/24 17:00
 **/
public class _673_最长递增子序列的个数 {

    /**
     * 线段树
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     */
    public int findNumberOfLIS(int[] nums) {
        // TODO https://www.bilibili.com/video/av47331849?t=1907
        return 0;
    }

    /**
     * DP
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    public int findNumberOfLIS1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int[] lengths = new int[length];
        int[] counts = new int[length];
        Arrays.fill(counts, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                if (lengths[j] >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    counts[i] = counts[j];
                } else if (lengths[j] + 1 == lengths[i]) {
                    counts[i] += counts[j];
                }
            }
        }
        int longest = Arrays.stream(lengths).max().getAsInt();
        int number = 0;
        for (int i = 0; i < length; i++) {
            if (lengths[i] == longest) {
                number += counts[i];
            }
        }
        return number;
    }

    /**
     * 题解：DP
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    public int findNumberOfLISAnswer(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        // lengths[i] = length of longest ending in nums[i]
        // 以nums[i]结尾的最长递增子序列的长度
        int[] lengths = new int[n];
        // count[i] = number of longest ending in nums[i]
        // 以nums[i]结尾的最长递增子序列长度的子序列个数
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < n; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }
}