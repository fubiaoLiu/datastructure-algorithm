package leetcode.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _1143_Test {
    _1143_最长公共子序列 lcs = new _1143_最长公共子序列();

    @Test
    public void test() {
        assertThat(lcs.longestCommonSubsequence1("abcde", "ace")).isEqualTo(3);
        assertThat(lcs.longestCommonSubsequence2("abcde", "ace")).isEqualTo(3);
        assertThat(lcs.longestCommonSubsequence3("abcde", "ace")).isEqualTo(3);
        assertThat(lcs.longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
    }
}
