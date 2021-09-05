package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例：
 * 输入：4
 * 输出：[
 * [".Q..",  // 解法 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * Related Topics 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/n-queens
 *
 * @author Fubiao.Liu
 * @since 2020/12/25 16:15
 **/
public class _51_N皇后 {
    /**
     * 递归+回溯
     * 用数组记录不能摆放的列、左斜线、右斜线，每次摆放皇后成功后更新这3个数组
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        // 初始化棋盘
        char[][] checkerboard = new char[n][n];
        for (char[] chars : checkerboard) {
            Arrays.fill(chars, '.');
        }
        boolean[] col = new boolean[n];
        int diagonalNum = (n << 1) - 1;
        boolean[] leftDiagonal = new boolean[diagonalNum];
        boolean[] rightDiagonal = new boolean[diagonalNum];
        List<List<String>> result = new ArrayList<>();
        dfs(checkerboard, result, col, leftDiagonal, rightDiagonal, n, 0);
        return result;
    }

    /**
     * 深度优先搜索
     */
    private void dfs(char[][] checkerboard, List<List<String>> result, boolean[] col,
                     boolean[] leftDiagonal, boolean[] rightDiagonal, int n, int level) {
        if (n == level) {
            List<String> list = new ArrayList<>(n);
            for (char[] chars : checkerboard) {
                list.add(new String(chars));
            }
            result.add(list);
        }
        for (int i = 0; i < n; i++) {
            if (canPut(col, leftDiagonal, rightDiagonal, n, level, i)) {
                checkerboard[level][i] = 'Q';
                setArray(col, leftDiagonal, rightDiagonal, n, level, i);
                dfs(checkerboard, result, col, leftDiagonal, rightDiagonal, n, level + 1);
                setArray(col, leftDiagonal, rightDiagonal, n, level, i);
                checkerboard[level][i] = '.';
            }
        }
    }

    /**
     * @return 是否可以摆放
     */
    private boolean canPut(boolean[] col, boolean[] leftDiagonal, boolean[] rightDiagonal, int n, int r, int c) {
        return !col[c] && !leftDiagonal[c + r] && !rightDiagonal[r - c + n - 1];
    }

    /**
     * 设置数组
     */
    private void setArray(boolean[] col, boolean[] leftDiagonal, boolean[] rightDiagonal, int n, int r, int c) {
        col[c] = !col[c];
        leftDiagonal[c + r] = !leftDiagonal[c + r];
        int rightDiagonalIdx = r - c + n - 1;
        rightDiagonal[rightDiagonalIdx] = !rightDiagonal[rightDiagonalIdx];
    }

    /**
     * 递归+回溯
     * 用两层循环判断是否可以摆放，效率低下
     */
    public List<List<String>> solveNQueens1(int n) {
        if (n <= 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        // 初始化棋盘
        char[][] checkerboard = new char[n][n];
        for (char[] chars : checkerboard) {
            Arrays.fill(chars, '.');
        }
        dfs(result, checkerboard, n, 0);
        return result;
    }

    /**
     * DFS
     */
    private void dfs(List<List<String>> result, char[][] checkerboard, int n, int level) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : checkerboard) {
                list.add(new String(chars));
            }
            result.add(list);
            return;
        }
        for (int i = 0; i < checkerboard.length; i++) {
            if (canPut(checkerboard, level, i)) {
                checkerboard[level][i] = 'Q';
                dfs(result, checkerboard, n, level + 1);
                checkerboard[level][i] = '.';
            }
        }
    }

    /**
     * @return 当前位置是否可以摆放
     */
    private boolean canPut(char[][] checkerboard, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < checkerboard.length; j++) {
                if (checkerboard[i][j] == 'Q' &&
                        (j == col || Math.abs(row - i) == Math.abs(j - col))) {
                    return false;
                }
            }
        }
        return true;
    }
}