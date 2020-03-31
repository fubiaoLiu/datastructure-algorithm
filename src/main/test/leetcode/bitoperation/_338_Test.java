package leetcode.bitoperation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class _338_Test {
    _338_比特位计数 countBits = new _338_比特位计数();

    @Test
    public void test1() {
        int[] result = countBits.countBits(2);
        assertThat(result.length).isEqualTo(3);
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(1);
    }

    @Test
    public void test2() {
        int[] result = countBits.countBits(5);
        assertThat(result.length).isEqualTo(6);
        assertThat(result[0]).isEqualTo(0);
        assertThat(result[1]).isEqualTo(1);
        assertThat(result[2]).isEqualTo(1);
        assertThat(result[3]).isEqualTo(2);
        assertThat(result[4]).isEqualTo(1);
        assertThat(result[5]).isEqualTo(2);
    }
}
