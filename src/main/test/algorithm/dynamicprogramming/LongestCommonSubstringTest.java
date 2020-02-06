package algorithm.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonSubstringTest {
    LongestCommonSubstring lisubstring = new LongestCommonSubstring();

    @Test
    public void test() {
        assertThat(lisubstring.lengthOfLIS("abcde", "abbcd")).isEqualTo(3);
        assertThat(lisubstring.lengthOfLIS1("abcde", "abbcd")).isEqualTo(3);
    }
}
