package algorithm.backtracking;

/**
 * 八皇后问题
 *
 * @author FuBiaoLiu
 * @since 2020/2/4
 */
public class Queen {
    /**
     * 索引为行号，值为列号
     */
    private int[] cols;
    /**
     * 共有多少种摆法
     */
    private int ways;

    public int placeQueens(int n) {
        if (n < 1) {
            return 0;
        }
        cols = new int[n];
        ways = 0;
        place(0);
        return ways;
    }

    private void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(col, row)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    /**
     * 第row行第col列是否有效（是否可以摆放皇后）
     *
     * @param col
     * @param row
     * @return true: 有效;false: 无效
     */
    private boolean isValid(int col, int row) {
        for (int i = 0; i < row; i++) {
            // 第i列已经有皇后
            if (col == cols[i]) {
                return false;
            }
            // 第i列的皇后跟第row行col列的皇后在同一条斜线上
            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
