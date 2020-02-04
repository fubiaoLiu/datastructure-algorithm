package leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _455_Test {
    _455_分发饼干 distributeBiscuits = new _455_分发饼干();

    @Test
    public void should_return_true_test1() {
        int[] g = {1, 2, 3}, s = {1, 1};
        assertThat(distributeBiscuits.findContentChildren(g, s)).isEqualTo(1);
    }

    @Test
    public void should_return_true_test2() {
        int[] g = {1, 2}, s = {1, 2, 3};
        assertThat(distributeBiscuits.findContentChildren(g, s)).isEqualTo(2);
    }
}
