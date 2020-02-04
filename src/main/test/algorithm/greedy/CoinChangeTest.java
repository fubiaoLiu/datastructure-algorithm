package algorithm.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinChangeTest {
    CoinChange coinChange = new CoinChange();

    @Test
    public void test_change1() {
        int[] faces = new int[]{25, 10, 5, 1};
        int money = 41;
        assertThat(coinChange.change1(faces, money)).isEqualTo(4);
    }
    @Test
    public void test_change2() {
        int[] faces = new int[]{25, 10, 5, 1};
        int money = 41;
        assertThat(coinChange.change2(faces, money)).isEqualTo(4);
    }
}
