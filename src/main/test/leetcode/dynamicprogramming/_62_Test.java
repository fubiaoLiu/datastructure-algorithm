package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * _62_不同路径测试类
 *
 * @author liufb
 * @since2020/5/18 10:32
 **/
public class _62_Test {
    _62_不同路径 diffPath = new _62_不同路径();

    @Test
    public void test() {
        assertThat(diffPath.uniquePaths(3, 2)).isEqualTo(3);
        assertThat(diffPath.uniquePaths(7, 3)).isEqualTo(28);
    }
}
