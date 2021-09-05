package leetcode.dfs;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集
 * <p>
 * https://leetcode-cn.com/problems/number-of-islands
 *
 * @author Fubiao.Liu
 * @since 2021/5/7 16:38
 **/
public class _200_岛屿数量 {

    /**
     * 深度优先遍历（代码优化）
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
            char[] line = grid[row];
            for (int col = 0; col < line.length; col++) {
                if (grid[row][col] == '1') {
                    num++;
                    dfs(grid, row, col);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    /**
     * 深度优先遍历
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        for (int row = 0; row < grid.length; row++) {
            char[] line = grid[row];
            for (int col = 0; col < line.length; col++) {
                if (grid[row][col] == '1') {
                    num++;
                    dfs1(grid, row, col);
                }
            }
        }
        return num;
    }

    private void dfs1(char[][] grid, int row, int col) {
        grid[row][col] = '0';
        int row1 = row - 1;
        if (row1 >= 0 && grid[row1][col] == '1') {
            dfs1(grid, row1, col);
        }
        int row2 = row + 1;
        if (row2 < grid.length && grid[row2][col] == '1') {
            dfs1(grid, row2, col);
        }
        int col1 = col - 1;
        if (col1 >= 0 && grid[row][col1] == '1') {
            dfs1(grid, row, col1);
        }
        int col2 = col + 1;
        if (col2 < grid[0].length && grid[row][col2] == '1') {
            dfs1(grid, row, col2);
        }
    }
}
