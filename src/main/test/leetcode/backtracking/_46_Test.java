package leetcode.backtracking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _46_Test {
    _46_全排列 permute = new _46_全排列();
    @Test
    public void test() {
        int[] nums = {1,2,3};
        assertThat(permute.permute(nums).size()).isEqualTo(6);
    }
}
