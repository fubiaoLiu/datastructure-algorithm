package leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _452_Test {
    _452_用最少数量的箭引爆气球 findMinArrowShots = new _452_用最少数量的箭引爆气球();

    @Test
    public void should_return_true_test1() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        assertThat(findMinArrowShots.findMinArrowShots(points)).isEqualTo(2);
    }
}
