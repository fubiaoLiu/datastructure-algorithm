package leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _605_Test {
    _605_种花问题 canPlaceFlowers = new _605_种花问题();

    @Test
    public void test() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        assertThat(canPlaceFlowers.canPlaceFlowers(flowerbed, 1)).isTrue();
        assertThat(canPlaceFlowers.canPlaceFlowers(flowerbed, 2)).isFalse();
    }
}
