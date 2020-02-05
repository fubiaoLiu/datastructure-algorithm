package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _40_Test {
    _40_组合总和2 combinationSum = new _40_组合总和2();

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum.combinationSum2(candidates, target);
        assertThat(result.size()).isEqualTo(4);
    }
}
