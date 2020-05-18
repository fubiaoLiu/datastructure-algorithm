package leetcode.dynamicprogramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * https://leetcode-cn.com/problems/unique-paths
 *
 * @author: liufb
 * @create: 2020/5/18 10:35
 **/
public class _62_不同路径 {
    /**
     * 第二个版本，优化空间复杂度
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m > n) {
            m += n;
            n = m - n;
            m -= n;
        }
        int[] dp = new int[m];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1];
    }

    /**
     * 第一个版本
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[m];
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}
