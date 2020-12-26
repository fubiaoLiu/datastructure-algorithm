package leetcode.dynamicprogramming;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
 * 到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 提示：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 * <p>
 * Related Topics 动态规划
 * <p>
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 *
 * @author Fubiao.Liu
 * @since 2020/12/15 17:19
 **/
public class _47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        for (int[] ints : grid) {
            dp[0] = dp[0] + ints[0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + ints[j];
            }
        }
        return dp[grid[0].length - 1];
    }
}