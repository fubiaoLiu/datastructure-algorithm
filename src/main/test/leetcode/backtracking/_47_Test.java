package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _47_Test {
    _47_全排列2 permute = new _47_全排列2();

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        assertThat(permute.permuteUnique(nums).size()).isEqualTo(3);
    }
}
