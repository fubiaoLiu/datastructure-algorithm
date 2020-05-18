package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description: _64_最小路径和测试类
 * @author: liufb
 * @create: 2020/5/18 10:32
 **/
public class _64_Test {
    _64_最小路径和 minPath = new _64_最小路径和();

    @Test
    public void test() {
        int[][] map = new int[3][3];
        map[0][0] = 1;
        map[0][1] = 3;
        map[0][2] = 1;
        map[1][0] = 1;
        map[1][1] = 5;
        map[1][2] = 1;
        map[2][0] = 4;
        map[2][1] = 2;
        map[2][2] = 1;
        assertThat(minPath.minPathSum(map)).isEqualTo(7);
    }
}
