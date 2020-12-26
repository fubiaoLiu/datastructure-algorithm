package algorithm.dynamicprogramming;

/**
 * 最长公共子串
 * 子串是连续的子序列
 *
 * @author FuBiaoLiu
 * @since 2020/2/6
 */
public class LongestCommonSubstring {
    /**
     * 动态规划 - 优化1 - 一维数组
     */
    public int lengthOfLIS(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) {
            return 0;
        }
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) {
            return 0;
        }
        char[] rows = chars1, cols = chars2;
        if (chars1.length < chars2.length) {
            rows = chars2;
            cols = chars1;
        }
        int[] dp = new int[cols.length + 1];
        int max = 0;
        for (int i = 1; i <= rows.length; i++) {
            for (int j = cols.length; j >= 1; j--) {
                dp[j] = rows[i - 1] == cols[j - 1] ? dp[j - 1] + 1 : 0;
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }

    /**
     * 动态规划 - 多维数组
     */
    public int lengthOfLIS1(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        if (chars1.length == 0) {
            return 0;
        }
        char[] chars2 = text2.toCharArray();
        if (chars2.length == 0) {
            return 0;
        }
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                dp[i][j] = chars1[i - 1] == chars2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
