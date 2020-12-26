package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * _75_颜色分类
 *
 * @author Fubiao.Liu
 * @since 2020/11/30 16:25
 **/
public class _75_Test {
    _75_颜色分类 sortColors = new _75_颜色分类();

    @Test
    public void test1() {
        int[] num = {1, 2, 0, 2, 1, 1};
        sortColors.sortColors(num);

        int[] expected = {0, 1, 1, 1, 2, 2};
        for (int i = 0; i < num.length; i++) {
            assertEquals(expected[i], num[i]);
        }
    }
}