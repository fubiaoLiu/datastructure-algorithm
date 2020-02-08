package algorithm.sequence;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KMPTest {
    KMP kmp = new KMP();
    @Test
    public void test(){
        String text = "Hello World";
        assertThat(kmp.indexOf(text, "or")).isEqualTo(7);
        assertThat(kmp.indexOf(text, "ld")).isEqualTo(9);
        assertThat(kmp.indexOf(text, "d")).isEqualTo(10);
        assertThat(kmp.indexOf(text, "H")).isEqualTo(0);
        assertThat(kmp.indexOf(text, "Hello World")).isEqualTo(0);
        assertThat(kmp.indexOf(text, "Hello World!")).isEqualTo(-1);
        assertThat(kmp.indexOf(text, "ldl")).isEqualTo(-1);
        assertThat(kmp.indexOf(text, "")).isEqualTo(-1);
    }
}
