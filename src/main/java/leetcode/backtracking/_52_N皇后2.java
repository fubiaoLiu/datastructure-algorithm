package leetcode.backtracking;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 上图为 8 皇后问题的一种解法。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 提示：
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
 * -1 步，可进可退。（引用自 百度百科 - 皇后 ）
 * <p>
 * Related Topics 回溯算法
 * <p>
 * https://leetcode-cn.com/problems/n-queens-ii/submissions/
 *
 * @author Fubiao.Liu
 * @since 2021/1/6 17:18
 **/
public class _52_N皇后2 {
    public int totalNQueens(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }
        boolean[] col = new boolean[n];
        int diagonalNum = (n << 1) - 1;
        boolean[] leftDiagonal = new boolean[diagonalNum];
        boolean[] rightDiagonal = new boolean[diagonalNum];
        return dfs(col, leftDiagonal, rightDiagonal, n, 0);
    }

    /**
     * 深度优先搜索
     */
    private int dfs(boolean[] col, boolean[] leftDiagonal, boolean[] rightDiagonal, int n, int level) {
        if (n == level) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (canPut(col, leftDiagonal, rightDiagonal, n, level, i)) {
                setArray(col, leftDiagonal, rightDiagonal, n, level, i);
                count += dfs(col, leftDiagonal, rightDiagonal, n, level + 1);
                setArray(col, leftDiagonal, rightDiagonal, n, level, i);
            }
        }
        return count;
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
}
