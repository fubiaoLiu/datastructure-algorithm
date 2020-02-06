package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _300_Test {
    _300_最长上升子序列 lis = new _300_最长上升子序列();

    @Test
    public void test() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        assertThat(lis.lengthOfLIS(nums)).isEqualTo(4);
    }
}
