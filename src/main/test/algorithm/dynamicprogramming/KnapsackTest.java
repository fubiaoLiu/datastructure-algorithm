package algorithm.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KnapsackTest {
    Knapsack knapsack = new Knapsack();

    @Test
    public void test_just_fill_up() {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        assertThat(knapsack.justFillUp(values, weights, 10)).isEqualTo(14);
        assertThat(knapsack.justFillUp(values, weights, 9)).isEqualTo(13);
        assertThat(knapsack.justFillUp(values, weights, 8)).isEqualTo(15);
        assertThat(knapsack.justFillUp(values, weights, 7)).isEqualTo(10);
        assertThat(knapsack.justFillUp(values, weights, 6)).isEqualTo(12);
        assertThat(knapsack.justFillUp(values, weights, 5)).isEqualTo(4);
        assertThat(knapsack.justFillUp(values, weights, 4)).isEqualTo(9);
        assertThat(knapsack.justFillUp(values, weights, 3)).isEqualTo(-1);
        assertThat(knapsack.justFillUp(values, weights, 2)).isEqualTo(6);
        assertThat(knapsack.justFillUp(values, weights, 1)).isEqualTo(-1);
    }

    @Test
    public void test() {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        assertThat(knapsack.select(values, weights, 10)).isEqualTo(15);
        assertThat(knapsack.select(values, weights, 7)).isEqualTo(12);
        assertThat(knapsack.select(values, weights, 5)).isEqualTo(9);
        assertThat(knapsack.select(values, weights, 3)).isEqualTo(6);
    }

    @Test
    public void test1() {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        assertThat(knapsack.select1(values, weights, 10)).isEqualTo(15);
        assertThat(knapsack.select1(values, weights, 7)).isEqualTo(12);
        assertThat(knapsack.select1(values, weights, 5)).isEqualTo(9);
        assertThat(knapsack.select1(values, weights, 3)).isEqualTo(6);
    }

    @Test
    public void test2() {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        assertThat(knapsack.select2(values, weights, 10)).isEqualTo(15);
        assertThat(knapsack.select2(values, weights, 7)).isEqualTo(12);
        assertThat(knapsack.select2(values, weights, 5)).isEqualTo(9);
        assertThat(knapsack.select2(values, weights, 3)).isEqualTo(6);
    }
}
