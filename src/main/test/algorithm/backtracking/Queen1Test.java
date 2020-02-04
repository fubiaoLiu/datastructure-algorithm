package algorithm.backtracking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Queen1Test {
    Queen1 queen = new Queen1();

    @Test
    public void should_return_true_test_queen_4() {
        assertThat(queen.placeQueens(4)).isEqualTo(2);
    }

    @Test
    public void should_return_true_test_queen_8() {
        assertThat(queen.placeQueens(8)).isEqualTo(92);
    }
}
