package leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _135_Test {
    _135_分发糖果 candy = new _135_分发糖果();

    @Test
    public void test() {
        assertThat(candy.candy(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy.candy(new int[]{1, 2, 2})).isEqualTo(4);
    }
}
