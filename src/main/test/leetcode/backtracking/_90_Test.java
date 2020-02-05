package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class _90_Test {
    _90_子集2 subsets = new _90_子集2();

    @Test
    public void test1() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        assertThat(result.size()).isEqualTo(6);
    }
    @Test
    public void test2() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsetsWithDup(nums);
        assertThat(result.size()).isEqualTo(8);
    }
}
