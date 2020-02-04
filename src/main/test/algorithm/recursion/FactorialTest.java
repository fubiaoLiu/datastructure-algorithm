package algorithm.recursion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @Test
    public void should_return_true_test_factorial1() {
        assertThat(factorial.factorial1(1)).isEqualTo(1);
        assertThat(factorial.factorial1(2)).isEqualTo(2);
        assertThat(factorial.factorial1(3)).isEqualTo(6);
        assertThat(factorial.factorial1(4)).isEqualTo(24);
        assertThat(factorial.factorial1(5)).isEqualTo(120);
        assertThat(factorial.factorial1(6)).isEqualTo(720);
    }


    @Test
    public void should_return_true_test_factorial2() {
        assertThat(factorial.factorial2(1)).isEqualTo(1);
        assertThat(factorial.factorial2(2)).isEqualTo(2);
        assertThat(factorial.factorial2(3)).isEqualTo(6);
        assertThat(factorial.factorial2(4)).isEqualTo(24);
        assertThat(factorial.factorial2(5)).isEqualTo(120);
        assertThat(factorial.factorial2(6)).isEqualTo(720);
    }
}
