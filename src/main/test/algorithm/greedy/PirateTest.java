package algorithm.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PirateTest {
    Pirate pirate = new Pirate();

    @Test
    public void test() {
        int[] weights = new int[]{3, 5, 4, 10, 7, 14, 2, 11};
        int capacity = 30;
        assertThat(pirate.pirate(weights, capacity)).isEqualTo(5);
    }
}
