package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _322_Test {
    _322_零钱兑换 coinChange = new _322_零钱兑换();

    @Test
    public void test1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        assertThat(coinChange.coinChange(coins, amount)).isEqualTo(3);
        assertThat(coinChange.coinChange1(coins, amount)).isEqualTo(3);
        assertThat(coinChange.coinChange2(coins, amount)).isEqualTo(3);
        assertThat(coinChange.coinChange3(coins, amount)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[] coins = {2};
        int amount = 3;
        assertThat(coinChange.coinChange(coins, amount)).isEqualTo(-1);
        assertThat(coinChange.coinChange1(coins, amount)).isEqualTo(-1);
        assertThat(coinChange.coinChange2(coins, amount)).isEqualTo(-1);
        assertThat(coinChange.coinChange3(coins, amount)).isEqualTo(-1);
    }

    @Test
    public void test3() {
        int[] coins = {2};
        int amount = 0;
        assertThat(coinChange.coinChange(coins, amount)).isEqualTo(0);
        assertThat(coinChange.coinChange1(coins, amount)).isEqualTo(0);
        assertThat(coinChange.coinChange2(coins, amount)).isEqualTo(0);
        assertThat(coinChange.coinChange3(coins, amount)).isEqualTo(0);
    }
}
