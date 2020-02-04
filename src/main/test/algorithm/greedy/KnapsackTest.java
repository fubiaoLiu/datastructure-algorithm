package algorithm.greedy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class KnapsackTest {
    Knapsack knapsack = new Knapsack();

    @Test
    public void test_price_ied() {
        assertThat(knapsack.pack("价格主导", (Article a1, Article a2) -> {
            return Double.compare(a2.getPrice(), a1.getPrice());
        })).isEqualTo(165);
    }

    @Test
    public void test_weight_ied() {
        assertThat(knapsack.pack("重量主导", Comparator.comparing(Article::getWeight))).isEqualTo(155);
    }

    @Test
    public void test_price_density_ied() {
        assertThat(knapsack.pack("价格密度主导", (Article a1, Article a2) -> {
            return Double.compare(a2.getPriceDensity(), a1.getPriceDensity());
        })).isEqualTo(170);
    }
}
