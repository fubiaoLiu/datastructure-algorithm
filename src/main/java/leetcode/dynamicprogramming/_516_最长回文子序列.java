package leetcode.dynamicprogramming;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 * 示例 1:
 * 输入: "bbbab"
 * 输出: 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入: "cbbd"
 * 输出: 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * @author Fubiao.Liu
 * @since 2020/12/24 21:01
 **/
public class _516_最长回文子序列 {
    /**
     * DP: 一维数组
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int leftTop;
        for (int i = dp.length - 1; i >= 0; i--) {
            leftTop = 0;
            dp[i] = 1;
            for (int j = i + 1; j < dp.length; j++) {
                if (chars[i] == chars[j]) {
                    int tmp = leftTop + 2;
                    leftTop = dp[j];
                    dp[j] = tmp;
                } else {
                    leftTop = dp[j];
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[chars.length - 1];
    }

    /**
     * DP: 二维数组
     * <p>
     * 状态
     * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     * <p>
     * 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * <p>
     * f[i][j] = f[i + 1][j - 1] + 2
     * <p>
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * <p>
     * f[i][j] = max(f[i + 1][j], f[i][j - 1])
     * <p>
     * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     * <p>
     * 初始化
     * f[i][i] = 1 单个字符的最长回文序列是 1
     * <p>
     * 结果
     * f[0][n - 1]
     */
    public int longestPalindromeSubseq1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < dp.length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][chars.length - 1];
    }
}