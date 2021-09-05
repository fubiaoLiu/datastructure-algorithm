package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * Related Topics 数组
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author Fubiao.Liu
 * @since 2021/2/2 16:59
 **/
public class _54_螺旋矩阵 {
    /**
     * 第二版本：代码精简
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // left top -> right top
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // right top -> right bottom
            for (int i = ++top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // 奇数行、偶数列的时候有问题
            if (top > bottom || --right < left) {
                break;
            }
            // right bottom -> left bottom
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            // left bottom -> left top
            for (int i = --bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    /**
     * 第一版本
     */
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        System.out.println("left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            System.out.println("① left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            System.out.println("② left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            if (top > --bottom) {
                break;
            }
            System.out.println("③ left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            System.out.println("④ left = " + left + ", right = " + right + ", top = " + top + ", bottom = " + bottom);
        }

        return result;
    }
}
