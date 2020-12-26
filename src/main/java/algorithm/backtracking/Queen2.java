package algorithm.backtracking;

/**
 * @description: 八皇后问题 - 优化2 - 使用位运算进一步压缩八皇后的空间复杂度（需要根据皇后数量使用合适的数据类型，8皇后可以使用byte，皇后数量超过64可以使用long数组）
 * @author FuBiaoLiu
 * @since 2020/2/4
 */
public class Queen2 {
    private static final int QUEEN_NUM = 8;
    /**
     * 标记某一列是否有皇后
     */
    private byte cols;
    /**
     * 标记某一对角线是否有皇后（左上角 -> 右下角）
     */
    private short leftTop;
    /**
     * 标记某一对角线是否有皇后（右上角 -> 左下角）
     */
    private short rightTop;
    /**
     * 共有多少种摆法
     */
    private int ways;

    public int place8Queens() {
        cols = 0;
        leftTop = 0;
        rightTop = 0;
        ways = 0;
        place(0);
        return ways;
    }

    private void place(int row) {
        if (row == QUEEN_NUM) {
            ways++;
            return;
        }
        for (int col = 0; col < QUEEN_NUM; col++) {
            int cv = 1 << col;
            int lv = 1 << (col + row);
            int rv = 1 << (row - col + QUEEN_NUM - 1);
            if (isValid(cv, lv, rv)) {
                cols |= cv;
                leftTop |= lv;
                rightTop |= rv;
                place(row + 1);
                cols &= ~cv;
                leftTop &= ~lv;
                rightTop &= ~rv;
            }
        }
    }

    private boolean isValid(int cv, int lv, int rv) {
        return (cols & cv) == 0 && (leftTop & lv) == 0 && (rightTop & rv) == 0;
    }
}
