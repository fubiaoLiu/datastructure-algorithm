package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _39_Test {
    _39_组合总和 combinationSum = new _39_组合总和();

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        assertThat(result.size()).isEqualTo(2);
    }
}
