package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static utils.Assertions.assertArrayAndListEquals;


public class _54_Test {
    _54_螺旋矩阵 obj = new _54_螺旋矩阵();

    @Test
    public void test1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        List<Integer> actual = obj.spiralOrder(matrix);
        assertArrayAndListEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Integer[] expected = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};

        // 1    2   3   4
        // 5    6   7   8
        // 9    10  11  12
        // init  : left = 0, right = 3, top = 0, bottom = 2
        // step 1: left = 0, right = 3, top = 1, bottom = 2
        // step 2: left = 0, right = 2, top = 1, bottom = 2
        // step 3: left = 0, right = 2, top = 1, bottom = 1
        // step 4: left = 1, right = 2, top = 1, bottom = 1
        // step 5: left = 1, right = 2, top = 2, bottom = 1
        List<Integer> actual = obj.spiralOrder(matrix);
        assertArrayAndListEquals(expected, actual);
    }
}
