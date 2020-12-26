package leetcode.characterstring;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * Related Topics 字符串 动态规划
 * <p>
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 13:43
 **/
public class _72_编辑距离 {
    /**
     * 动态规划：一维数组
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[] dp = new int[cs2.length + 1];
        for (int i = 0; i <= cs2.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= cs1.length; i++) {
            int tmpLeftTop = dp[0];
            dp[0] = i;
            for (int j = 1; j <= cs2.length; j++) {
                int top = dp[j] + 1;
                int left = dp[j - 1] + 1;
                int leftTop = cs1[i - 1] == cs2[j - 1] ? tmpLeftTop : tmpLeftTop + 1;
                tmpLeftTop = dp[j];
                dp[j] = Math.min(Math.min(top, left), leftTop);
            }
        }
        return dp[cs2.length];
    }

    /**
     * 动态规划：二维数组
     */
    public int minDistance1(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null) {
            return word2.length();
        }
        if (word2 == null) {
            return word1.length();
        }
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= cs1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= cs2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftTop = cs1[i - 1] == cs2[j - 1] ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(top, left), leftTop);
            }
        }
        return dp[cs1.length][cs2.length];
    }
}