package algorithm.sequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BruteForceTest {
    BruteForce bf = new BruteForce();

    @Test
    public void test_indexOf() {
        String text = "Hello World";
        assertThat(bf.indexOf(text, "or")).isEqualTo(7);
        assertThat(bf.indexOf(text, "ld")).isEqualTo(9);
        assertThat(bf.indexOf(text, "d")).isEqualTo(10);
        assertThat(bf.indexOf(text, "H")).isEqualTo(0);
        assertThat(bf.indexOf(text, "Hello World")).isEqualTo(0);
        assertThat(bf.indexOf(text, "Hello World!")).isEqualTo(-1);
        assertThat(bf.indexOf(text, "ldl")).isEqualTo(-1);
        assertThat(bf.indexOf(text, "")).isEqualTo(-1);
    }
    @Test
    public void test_indexOf2() {
        String text = "Hello World";
        assertThat(bf.indexOf2(text, "or")).isEqualTo(7);
        assertThat(bf.indexOf2(text, "ld")).isEqualTo(9);
        assertThat(bf.indexOf2(text, "d")).isEqualTo(10);
        assertThat(bf.indexOf2(text, "H")).isEqualTo(0);
        assertThat(bf.indexOf2(text, "Hello World")).isEqualTo(0);
        assertThat(bf.indexOf2(text, "Hello World!")).isEqualTo(-1);
        assertThat(bf.indexOf2(text, "ldl")).isEqualTo(-1);
        assertThat(bf.indexOf2(text, "")).isEqualTo(-1);
    }
    @Test
    public void test_indexOf1() {
        String text = "Hello World";
        assertThat(bf.indexOf1(text, "or")).isEqualTo(7);
        assertThat(bf.indexOf1(text, "ld")).isEqualTo(9);
        assertThat(bf.indexOf1(text, "d")).isEqualTo(10);
        assertThat(bf.indexOf1(text, "H")).isEqualTo(0);
        assertThat(bf.indexOf1(text, "Hello World")).isEqualTo(0);
        assertThat(bf.indexOf1(text, "Hello World!")).isEqualTo(-1);
        assertThat(bf.indexOf1(text, "ldl")).isEqualTo(-1);
        assertThat(bf.indexOf1(text, "")).isEqualTo(-1);
    }
}
