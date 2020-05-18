package leetcode.dynamicprogramming;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * https://leetcode-cn.com/problems/unique-paths-ii
 *
 * @author: liufb
 * @create: 2020/5/18 10:55
 **/
public class _63_不同路径 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];
        if (obstacleGrid[0][0] == 0) {
            dp[0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (dp[i - 1] == 1 && obstacleGrid[0][i] == 0) {
                dp[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
}
