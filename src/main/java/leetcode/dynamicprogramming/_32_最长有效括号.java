package leetcode.dynamicprogramming;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * Related Topics 字符串 动态规划
 * <p>
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 15:27
 **/
public class _32_最长有效括号 {
    /**
     * 一维数组优化
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // dp[i] = dp[i-2] + 2;
        // dp[i] = dp[i-1] + 2 + dp[ i- dp[i-1]- 2]
        int[] dp = new int[chars.length];
        int max = 0;
        int front;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                continue;
            }
            if (chars[i - 1] == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else if (i - dp[i - 1] > 0 && chars[(front = i - dp[i - 1] - 2) + 1] == '(') {
                dp[i] = (front >= 0 ? dp[front] : 0) + dp[i - 1] + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 一维数组
     */
    public int longestValidParentheses2(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // dp[i][j]: 表示[i,j]范围的子串是否是有效括号
        int[] dp = new int[chars.length + 1];
        int max = 0;
        int front;
        for (int i = 1; i <= chars.length; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                if (chars[j - 1] == '(') {
                    dp[j] = 0;
                } else if (chars[j - 2] == '(') {
                    dp[j] = dp[j - 2] + 2;
                } else if (dp[j - 1] <= 0) {
                    dp[j] = 0;
                } else if ((front = j - dp[j - 1] - 2) >= i - 1 && chars[front] == '(') {
                    dp[j] = (front > i ? dp[front] : 0) + dp[j - 1] + 2;
                } else {
                    dp[j] = 0;
                }
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    /**
     * 多维数组
     */
    public int longestValidParentheses1(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // dp[i][j]: 表示[i,j]范围的子串是否是有效括号
        int[][] dp = new int[chars.length + 1][chars.length + 1];
        int max = 0;
        int front;
        for (int i = 1; i <= chars.length; i++) {
            for (int j = i + 1; j <= chars.length; j++) {
                if (chars[j - 1] == '(') {
                    dp[i][j] = 0;
                } else if (chars[j - 2] == '(') {
                    dp[i][j] = dp[i][j - 2] + 2;
                } else if (dp[i][j - 1] <= 0) {
                    dp[i][j] = 0;
                } else if ((front = j - dp[i][j - 1] - 2) >= 0 && chars[front] == '(') {
                    dp[i][j] = (front > 0 ? dp[i][front] : 0) + dp[i][j - 1] + 2;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}