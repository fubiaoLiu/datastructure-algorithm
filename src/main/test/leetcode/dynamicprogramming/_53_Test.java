package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _53_Test {
    _53_最大连续子序和 maxSubArray = new _53_最大连续子序和();

    @Test
    public void should_return_true() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertThat(maxSubArray.maxSubArray(nums)).isEqualTo(6);
    }
}
