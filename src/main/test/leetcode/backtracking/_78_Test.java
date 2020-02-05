package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _78_Test {
    _78_子集 subsets = new _78_子集();

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);
        assertThat(result.size()).isEqualTo(8);
    }
}
