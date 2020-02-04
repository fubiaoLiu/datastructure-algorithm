package algorithm.backtracking;

/**
 * @description: 八皇后问题 - 优化1 - 使用布尔数组记录每一列每一条斜线是否已存在皇后
 * @author: FuBiaoLiu
 * @date: 2020/2/4
 */
public class Queen1 {
    /**
     * 标记某一列是否有皇后，索引为列号
     */
    private boolean[] cols;
    /**
     * 标记某一对角线是否有皇后（左上角 -> 右下角）
     */
    private boolean[] leftTop;
    /**
     * 标记某一对角线是否有皇后（右上角 -> 左下角）
     */
    private boolean[] rightTop;
    /**
     * 共有多少种摆法
     */
    private int ways;

    public int placeQueens(int n) {
        if (n < 1) {
            return 0;
        }
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[(n << 1) - 1];
        ways = 0;
        place(0);
        return ways;
    }

    private void place(int row) {
        if (row == cols.length) {
            ways++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            int leftIndex = col + row;
            int rightIndex = row - col + cols.length - 1;

            if (isValid(col, leftIndex, rightIndex)) {
                cols[col] = leftTop[leftIndex] = rightTop[rightIndex] = true;
                place(row + 1);
                cols[col] = leftTop[leftIndex] = rightTop[rightIndex] = false;
            }
        }
    }

    /**
     * 第row行第col列是否有效（是否可以摆放皇后）
     *
     * @param col
     * @param leftIndex
     * @param rightIndex
     * @return true: 有效;false: 无效
     */
    private boolean isValid(int col, int leftIndex, int rightIndex) {
        return !(cols[col] || leftTop[leftIndex] || rightTop[rightIndex]);
    }
}
