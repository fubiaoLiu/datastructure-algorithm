package algorithm.backtracking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Queen2Test {
    Queen2 queen = new Queen2();

    @Test
    public void should_return_true_test_queen_8() {
        assertThat(queen.place8Queens()).isEqualTo(92);
    }
}
