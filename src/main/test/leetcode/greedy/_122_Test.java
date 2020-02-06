package leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _122_Test {
    _122_买卖股票的最佳时机2 maxProfit = new _122_买卖股票的最佳时机2();

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertThat(maxProfit.maxProfit(prices)).isEqualTo(7);
    }
}
