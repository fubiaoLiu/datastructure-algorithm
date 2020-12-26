package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * _63_不同路径2测试类
 *
 * @author liufb
 * @since2020/5/18 10:32
 **/
public class _63_Test {
    _63_不同路径 diffPath = new _63_不同路径();

    @Test
    public void test1() {
        int[][] map = new int[3][3];
        map[1][1] = 1;
        assertThat(diffPath.uniquePathsWithObstacles(map)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int[][] map = {{0, 1}};
        assertThat(diffPath.uniquePathsWithObstacles(map)).isEqualTo(0);
    }

    @Test
    public void test3() {
        int[][] map = {{0}, {1}};
        assertThat(diffPath.uniquePathsWithObstacles(map)).isEqualTo(0);
    }
}
