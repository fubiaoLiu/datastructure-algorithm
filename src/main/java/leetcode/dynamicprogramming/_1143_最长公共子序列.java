package leetcode.dynamicprogramming;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 * 示例 1:
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * <p>
 * 示例 2:
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * <p>
 * 示例 3:
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/longest-common-subsequence
 *
 * @author FuBiaoLiu
 * @since 2020/2/6
 */
public class _1143_最长公共子序列 {
    /**
     * 非递归实现 - 优化2 - 一维数组(优化空间复杂度)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
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
        for (int i = 1; i <= rows.length; i++) {
            int cur = 0;
            for (int j = 1; j <= cols.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rows[i - 1] == cols[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[cols.length];
    }

    /**
     * 非递归实现 - 优化1 - 滚动数组(优化空间复杂度)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence3(String text1, String text2) {
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
        int[][] dp = new int[2][cols.length + 1];
        for (int i = 0; i < rows.length; i++) {
            int row = (i + 1) & 1;
            int preRow = i & 1;
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] == cols[j]) {
                    dp[row][j + 1] = dp[preRow][j] + 1;
                } else {
                    dp[row][j + 1] = Math.max(dp[preRow][j + 1], dp[row][j]);
                }
            }
        }
        return dp[rows.length & 1][cols.length];
    }

    /**
     * 非递归实现
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
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
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    /**
     * 递归实现
     */
    public int longestCommonSubsequence1(String text1, String text2) {
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
        return lcs(chars1, chars1.length - 1, chars2, chars2.length - 1);
    }

    private int lcs(char[] chars1, int index1, char[] chars2, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (chars1[index1] == chars2[index2]) {
            return lcs(chars1, index1 - 1, chars2, index2 - 1) + 1;
        }
        return Math.max(
                lcs(chars1, index1 - 1, chars2, index2),
                lcs(chars1, index1, chars2, index2 - 1));
    }

    // ----------------------------第三季练习-------------------------------
    public int longestCommonSubsequence4(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public int longestCommonSubsequence5(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[] dp = new int[chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            int leftTop = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int tmp = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftTop = tmp;
            }
        }
        return dp[chars2.length];
    }
}
